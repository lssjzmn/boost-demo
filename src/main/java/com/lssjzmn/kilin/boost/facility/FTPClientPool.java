package com.lssjzmn.kilin.boost.facility;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by guimu-work on 2018/7/12.
 */
public class FTPClientPool implements ObjectPool<FTPClient> {

    private static final int MAX_POOL_LENGTH = 30;
    private static final int MAX_WAIT_TIME = 2;
    private static final int FTP_DATA_TIMEOUT = 20 * 1000;
    private static final int FTP_CONN_TIMEOUT = 5 * 60 * 1000;
    private static final long CONTROL_KEEP_ALIVE_TIME = 5;//sec
    private LinkedBlockingQueue<FTPClient> pool;
    private FtpClientParam ftpClientParam;
    private final Object lock = new Object();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public FTPClientPool(int poolSize, FtpClientParam ftpClientParam) throws Exception {
        this.pool = new LinkedBlockingQueue<>(poolSize + MAX_POOL_LENGTH);
        this.ftpClientParam = ftpClientParam;
        for (int i = 0; i < poolSize; i++) {
            addObject();
        }
    }

    @Override
    public FTPClient borrowObject() throws Exception {
        FTPClient ftpClient = pool.poll(MAX_WAIT_TIME, TimeUnit.SECONDS);
        logger.info(" borrow - ftpClient 剩余 " + pool.size());
        if (ftpClient == null) {
            return makeFtpClient();
        } else {
            try {
                if (ftpClient.sendNoOp())
                    return ftpClient;
                else {
                    invalidateObject(ftpClient);
                    return makeFtpClient();
                }
            } catch (Exception e) {
                invalidateObject(ftpClient);
                return makeFtpClient();
            }
        }
    }

    private FTPClient makeFtpClient() throws Exception {
        FTPClient ftpClient;
        ftpClient = getFtpClient();
        if (ftpClient != null)
            pool.put(ftpClient);
        return ftpClient;
    }

    @Override
    public void returnObject(FTPClient ftpClient) throws Exception {
        if (ftpClient == null)
            return;
        if (!pool.offer(ftpClient, MAX_WAIT_TIME, TimeUnit.SECONDS)) {
            closeFtp(ftpClient);
            makeFtpClient();
        }
        logger.info(" return - ftpClient 剩余 " + pool.size());
    }

    @Override
    public void invalidateObject(FTPClient ftpClient) throws Exception {
        pool.remove(ftpClient);
    }

    @Override
    public void addObject() throws Exception {
        FTPClient ftpClient = getFtpClient();
        if (ftpClient != null)
            pool.put(ftpClient);
    }

    @Override
    public int getNumIdle() throws UnsupportedOperationException {
        return 0;
    }

    @Override
    public int getNumActive() throws UnsupportedOperationException {
        return 0;
    }

    @Override
    public void clear() throws Exception {
        pool.clear();
    }

    @Override
    public void close() throws Exception {
        while (pool.iterator().hasNext()) {
            FTPClient client = pool.poll();
            closeFtp(client);
        }
    }

    @Override
    public void setFactory(PoolableObjectFactory<FTPClient> poolableObjectFactory) throws IllegalStateException, UnsupportedOperationException {

    }

    private FTPClient getFtpClient() throws Exception {
        synchronized (lock) {
            FTPClient ftpClient = new FTPClient();
            connectFtpSvr(ftpClient);
            if (!ftpClient.changeWorkingDirectory(ftpClientParam.getRecordId())) {
                logger.error("ftpClient change working directory failed: " + ftpClientParam.getRecordId());
                throw new Exception();
            }
            return ftpClient;
        }
    }

    private void connectFtpSvr(FTPClient ftpClient) throws Exception {
        if (ftpClient.isConnected())
            return;
        configFtpClient(ftpClient);
        try {
            ftpClient.connect(ftpClientParam.getHost(), ftpClientParam.getPort());
        } catch (Exception e) {
            throw new Exception();
        }
        int reply = ftpClient.getReplyCode();//SERVICE_READY:220
        if (!FTPReply.isPositiveCompletion(reply)) {
            closeFtp(ftpClient);
            logger.info("ftp server reply problem, host is " + ftpClientParam.getHost()
                    + " replyCode : " + reply);
            throw new Exception();
        }
        if (ftpClient.login(ftpClientParam.getUserName(), ftpClientParam.getPassword())) {
            logger.info("ftp client login success, host is " + ftpClientParam.getHost()
                    + " replyCode : " + reply);
        } else {
            logger.info("ftp client login failed, host is " + ftpClientParam.getHost());
            closeFtp(ftpClient);
            throw new Exception();
        }
    }

    private void configFtpClient(FTPClient ftpClient) throws IOException {
        ftpClient.enterLocalPassiveMode();
        ftpClient.setRemoteVerificationEnabled(false);
        /*send a safe command  over the control connection to reset the router's idle timer.*/
        ftpClient.setControlKeepAliveTimeout(CONTROL_KEEP_ALIVE_TIME);
        ftpClient.setConnectTimeout(FTP_CONN_TIMEOUT);
        ftpClient.setDataTimeout(FTP_DATA_TIMEOUT);
        ftpClient.setBufferSize(4096);
        //ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
    }

    private void closeFtp(FTPClient ftpClient) {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
                ftpClient = null;
            } catch (IOException ioe) {
                logger.error(ioe.getMessage());
            }
        }
    }

}
