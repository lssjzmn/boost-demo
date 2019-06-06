package com.lssjzmn.kilin.boost.context;

import com.lssjzmn.kilin.boost.facility.FilePersistentUtil;

import java.io.File;

public class DynamicParameter {

    private String version = "v1.01.00.20190528_Release";
    public static final String CONFIG_IP_CONFIG_JSON = "./config/ipConfig.json";
    public static final String CONFIG_DIR = "./config";
    private static DynamicParameter dynamicParameter;

    //IP配置参数
    private String brokerURL = "tcp://192.168.1.10:61616";
    private String serverURL = "http://192.168.1.11:8088/client/";
    private String restIp = "192.168.1.11";
    private String brokerIP = "192.168.1.10";

    private static final String BROKERURL_PREFFIX = "tcp://";
    private static final String BROKERURL_SUFFIX = ":61616";

    private static final String SERVERURL_PREFFIX = "http://";
    private static final String SERVERURL_SUFFIX = ":8088/client/";

    //日志FTP配置参数
    private String cameraFtpUsername = "guimupicture";//guimupicture  //guimu
    private String cameraFtpPasswd = "guimupicture";//guimupicture  //guimu
    private String serverFtpUsername = "guimuradar";//guimuradar  //guimu
    private String serverFtpPasswd = "guimuradar";//guimuradar  //guimu
    private String robotFtpUsername = "guimuradar";//guimuradar //ftp
    private String robotFtpPasswd = "guimuradar";//guimuradar //guimurobotftp

    //检测数据FTP配置参数
    private String cameraFtpInfoHead = "ftp://192.168.1.11/";
    private String cameraXmlFtpInfoHead = "ftp://192.168.1.11/";
    private String radarFtpInfoHead = "ftp://192.168.1.10/radar/";
    private String metadataFtpInfoHead = "ftp://192.168.1.11/metadatas/";

    public String cameraFtpInfoTail = "/camera/raw?username=" + cameraFtpUsername + "&password=" + cameraFtpPasswd
            + "&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&delay=4s&noop=true&idempotent=true";
    public String cameraXmlFtpInfoTail = "?username=" + cameraFtpUsername + "&password=" + cameraFtpPasswd
            + "&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&delay=4s&noop=true&idempotent=true";
    public String radarFtpInfoTail = "?username=" + robotFtpUsername + "&password=" + robotFtpPasswd
            + "&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&delay=10s&noop=true&idempotent=true";
    public String metadataFtpInfoTail = "?username=" + cameraFtpUsername + "&password=" + cameraFtpPasswd
            + "&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&delay=120s&noop=true&idempotent=true";


    private DynamicParameter() {
    }

    public static DynamicParameter getInstance() {
        if (dynamicParameter == null) {
            dynamicParameter = new DynamicParameter();
            readStoredParameter();
        }
        return dynamicParameter;
    }

    public String getBrokerURL() {
        return brokerURL;
    }

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    public String getRestIp() {
        return restIp;
    }

    public void setRestIp(String restIp) {
        this.restIp = restIp;
        this.serverURL = SERVERURL_PREFFIX + restIp + SERVERURL_SUFFIX;

    }

    public String getBrokerIP() {
        return brokerIP;
    }

    public void setBrokerIP(String brokerIP) {
        this.brokerIP = brokerIP;
        this.brokerURL = BROKERURL_PREFFIX + brokerIP + BROKERURL_SUFFIX;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCameraFtpUsername() {
        return cameraFtpUsername;
    }

    public void setCameraFtpUsername(String cameraFtpUsername) {
        this.cameraFtpUsername = cameraFtpUsername;
    }

    public String getCameraFtpPasswd() {
        return cameraFtpPasswd;
    }

    public void setCameraFtpPasswd(String cameraFtpPasswd) {
        this.cameraFtpPasswd = cameraFtpPasswd;
    }

    public String getServerFtpUsername() {
        return serverFtpUsername;
    }

    public void setServerFtpUsername(String serverFtpUsername) {
        this.serverFtpUsername = serverFtpUsername;
    }

    public String getServerFtpPasswd() {
        return serverFtpPasswd;
    }

    public void setServerFtpPasswd(String serverFtpPasswd) {
        this.serverFtpPasswd = serverFtpPasswd;
    }

    public String getRobotFtpUsername() {
        return robotFtpUsername;
    }

    public void setRobotFtpUsername(String robotFtpUsername) {
        this.robotFtpUsername = robotFtpUsername;
    }

    public String getRobotFtpPasswd() {
        return robotFtpPasswd;
    }

    public void setRobotFtpPasswd(String robotFtpPasswd) {
        this.robotFtpPasswd = robotFtpPasswd;
    }

    public String getCameraFtpInfoHead() {
        return cameraFtpInfoHead;
    }

    public void setCameraFtpInfoHead(String cameraFtpInfoHead) {
        this.cameraFtpInfoHead = cameraFtpInfoHead;
    }

    public String getRadarFtpInfoHead() {
        return radarFtpInfoHead;
    }

    public String getCameraXmlFtpInfoHead() {
        return cameraXmlFtpInfoHead;
    }

    public void setCameraXmlFtpInfoHead(String cameraXmlFtpInfoHead) {
        this.cameraXmlFtpInfoHead = cameraXmlFtpInfoHead;
    }

    public void setRadarFtpInfoHead(String radarFtpInfoHead) {
        this.radarFtpInfoHead = radarFtpInfoHead;
    }

    public String getMetadataFtpInfoHead() {
        return metadataFtpInfoHead;
    }

    public void setMetadataFtpInfoHead(String metadataFtpInfoHead) {
        this.metadataFtpInfoHead = metadataFtpInfoHead;
    }

    public String getCameraXmlFtpInfoTail() {
        return cameraXmlFtpInfoTail;
    }

    public void setCameraXmlFtpInfoTail(String cameraXmlFtpInfoTail) {
        this.cameraXmlFtpInfoTail = cameraXmlFtpInfoTail;
    }

    public String getCameraFtpInfoTail() {
        return cameraFtpInfoTail;
    }

    public void setCameraFtpInfoTail(String cameraFtpInfoTail) {
        this.cameraFtpInfoTail = cameraFtpInfoTail;
    }

    public String getRadarFtpInfoTail() {
        return radarFtpInfoTail;
    }

    public void setRadarFtpInfoTail(String radarFtpInfoTail) {
        this.radarFtpInfoTail = radarFtpInfoTail;
    }

    public String getMetadataFtpInfoTail() {
        return metadataFtpInfoTail;
    }

    public void setMetadataFtpInfoTail(String metadataFtpInfoTail) {
        this.metadataFtpInfoTail = metadataFtpInfoTail;
    }

    public static void saveValidParameter() {
        File dir = new File(CONFIG_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String configPath = CONFIG_IP_CONFIG_JSON;
        FilePersistentUtil.writeJsonFile(configPath, DynamicParameter.getInstance());
    }

    private static void readStoredParameter() {
        String configPath = CONFIG_IP_CONFIG_JSON;
        File configFile = new File(configPath);
        if (!configFile.exists()) {
            return;
        }
        DynamicParameter savedParameter = (DynamicParameter) FilePersistentUtil.getObjectFromJson(DynamicParameter.class, configPath);
        dynamicParameter.setVersion(savedParameter.getVersion());
        dynamicParameter.setRestIp(savedParameter.getRestIp());
        dynamicParameter.setBrokerIP(savedParameter.getBrokerIP());

        dynamicParameter.setCameraFtpUsername(savedParameter.getCameraFtpUsername());
        dynamicParameter.setCameraFtpPasswd(savedParameter.getCameraFtpPasswd());
        dynamicParameter.setServerFtpUsername(savedParameter.getServerFtpUsername());
        dynamicParameter.setServerFtpPasswd(savedParameter.getServerFtpPasswd());
        dynamicParameter.setRobotFtpUsername(savedParameter.getRobotFtpUsername());
        dynamicParameter.setRobotFtpPasswd(savedParameter.getRobotFtpPasswd());

        dynamicParameter.setCameraFtpInfoHead(savedParameter.getCameraFtpInfoHead());
        dynamicParameter.setCameraFtpInfoTail(savedParameter.getCameraFtpInfoTail());
        dynamicParameter.setRadarFtpInfoHead(savedParameter.getRadarFtpInfoHead());
        dynamicParameter.setRadarFtpInfoTail(savedParameter.getRadarFtpInfoTail());
        dynamicParameter.setMetadataFtpInfoHead(savedParameter.getMetadataFtpInfoHead());
        dynamicParameter.setMetadataFtpInfoTail(savedParameter.getMetadataFtpInfoTail());
    }
}
