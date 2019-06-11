package com.lssjzmn.kilin.boost.bo.dataverify;

public class VerifyResult {

    private String recordId;
    private int trackSize;

    private boolean isCameraXmlExist;
    private int cameraXmlPicNum;
    private int cameraFilePicNum;

    private int radarFileNum;

    private boolean isWorkFrameFileExist;
    private boolean isMissionFileExist;
    private boolean isRecordFileExist;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public int getTrackSize() {
        return trackSize;
    }

    public void setTrackSize(int trackSize) {
        this.trackSize = trackSize;
    }

    public boolean isCameraXmlExist() {
        return isCameraXmlExist;
    }

    public void setCameraXmlExist(boolean cameraXmlExist) {
        isCameraXmlExist = cameraXmlExist;
    }

    public int getCameraXmlPicNum() {
        return cameraXmlPicNum;
    }

    public void setCameraXmlPicNum(int cameraXmlPicNum) {
        this.cameraXmlPicNum = cameraXmlPicNum;
    }

    public int getCameraFilePicNum() {
        return cameraFilePicNum;
    }

    public void setCameraFilePicNum(int cameraFilePicNum) {
        this.cameraFilePicNum = cameraFilePicNum;
    }

    public int getRadarFileNum() {
        return radarFileNum;
    }

    public void setRadarFileNum(int radarFileNum) {
        this.radarFileNum = radarFileNum;
    }

    public boolean isWorkFrameFileExist() {
        return isWorkFrameFileExist;
    }

    public void setWorkFrameFileExist(boolean workFrameFileExist) {
        isWorkFrameFileExist = workFrameFileExist;
    }

    public boolean isMissionFileExist() {
        return isMissionFileExist;
    }

    public void setMissionFileExist(boolean missionFileExist) {
        isMissionFileExist = missionFileExist;
    }

    public boolean isRecordFileExist() {
        return isRecordFileExist;
    }

    public void setRecordFileExist(boolean recordFileExist) {
        isRecordFileExist = recordFileExist;
    }

    @Override
    public String toString() {
        return "VerifyResult{" +
                "recordId='" + recordId + '\'' +
                ", trackSize=" + trackSize +
                ", isCameraXmlExist=" + isCameraXmlExist +
                ", cameraXmlPicNum=" + cameraXmlPicNum +
                ", cameraFilePicNum=" + cameraFilePicNum +
                ", radarFileNum=" + radarFileNum +
                ", isWorkFrameFileExist=" + isWorkFrameFileExist +
                ", isMissionFileExist=" + isMissionFileExist +
                ", isRecordFileExist=" + isRecordFileExist +
                '}';
    }
}
