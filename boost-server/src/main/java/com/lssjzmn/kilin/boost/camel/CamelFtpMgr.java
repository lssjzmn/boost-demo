package com.lssjzmn.kilin.boost.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelFtpMgr {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String ftpInfo;
    private String localDir;

    public boolean startCamelFtp() throws Exception {
        if (ftpInfo == null || localDir == null) {
            logger.info("CamelFtpMgr failed because of params error.");
            return false;
        }
        logger.info("CamelFtpMgr started for " + ftpInfo);
        ModelCamelContext camelContext = new DefaultCamelContext();
        camelContext.start();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(ftpInfo).process(new CamelFtpProcessor()).to(localDir);
            }
        });
        return true;
    }

    public String getFtpInfo() {
        return ftpInfo;
    }

    public void setFtpInfo(String ftpInfo) {
        this.ftpInfo = ftpInfo;
    }

    public String getLocalDir() {
        return localDir;
    }

    public void setLocalDir(String localDir) {
        this.localDir = localDir;
    }

}
