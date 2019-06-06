package com.lssjzmn.kilin.boost.facility;

/**
 * Created by guimu-work on 2018/1/8.
 */

public class FtpClientParam {

    private boolean isConnected = false;

    /*
    * 雷达："192.168.1.10"(低速车), "192.168.1.30"(高速车)
    * 相机："192.168.1.11"(低速车), "192.168.1.11"(高速车)
    * */
    private String host = "192.168.1.210";

    private Integer port = 21;

    private String userName = "ftp";//相机guimu

    private String password = "guimurobotftp";//相机guimu

    private String dataTypeFolder = "";

    private String recordIdFolder = "c:\\detectData\\no_name";

    private String recordId = "";

    private FileType fileType;

    public FtpClientParam(String host, Integer port, String userName, String password, String dataTypeFolder, String recordIdFolder, String recordId, FileType fileType) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.dataTypeFolder = dataTypeFolder;
        this.recordIdFolder = recordIdFolder;
        this.recordId = recordId;
        this.fileType = fileType;
    }

    public FtpClientParam(String host, String dataTypeFolder, String recordIdFolder, String recordId, FileType fileType) {
        this.host = host;
        this.dataTypeFolder = dataTypeFolder;
        this.recordIdFolder = recordIdFolder;
        this.recordId = recordId;
        this.fileType = fileType;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDataTypeFolder() {
        return dataTypeFolder;
    }

    public void setDataTypeFolder(String dataTypeFolder) {
        this.dataTypeFolder = dataTypeFolder;
    }

    public String getRecordIdFolder() {
        return recordIdFolder;
    }

    public void setRecordIdFolder(String recordIdFolder) {
        this.recordIdFolder = recordIdFolder;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }
}
