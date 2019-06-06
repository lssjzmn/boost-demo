package com.lssjzmn.kilin.boost.bo.dataverify;

public class VerifyTarget {

    private String targetDir;

    private String targetName;

    private int trackSize;

    public VerifyTarget(String targetDir, String targetName, int trackSize) {
        this.targetDir = targetDir;
        this.targetName = targetName;
        this.trackSize = trackSize;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getTrackSize() {
        return trackSize;
    }

    public void setTrackSize(int trackSize) {
        this.trackSize = trackSize;
    }

    @Override
    public String toString() {
        return "VerifyTarget{" +
                "targetDir='" + targetDir + '\'' +
                ", targetName='" + targetName + '\'' +
                ", trackSize=" + trackSize +
                '}';
    }
}
