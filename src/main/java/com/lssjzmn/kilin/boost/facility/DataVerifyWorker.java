package com.lssjzmn.kilin.boost.facility;

import com.lssjzmn.kilin.boost.bo.dataverify.VerifyResult;
import com.lssjzmn.kilin.boost.bo.dataverify.VerifyTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DataVerifyWorker {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private VerifyTarget verifyTarget;

    public synchronized VerifyResult doVerify() {
        VerifyResult verifyResult = new VerifyResult();
        verifyResult.setRecordId(verifyTarget.getTargetName());
        verifyResult.setTrackSize(verifyTarget.getTrackSize());
        String dataDirName = verifyTarget.getTargetDir();
        File dataDir = new File(dataDirName);
        if (!dataDir.exists()) {
            logger.info(dataDirName + " not exists.***");
            return verifyResult;
        }
        File radarDir = new File(dataDir + "\\radar\\raw");
        if (radarDir.exists() && radarDir.isDirectory()) {
            verifyResult.setRadarFileNum(radarDir.listFiles().length);
        }

        File cameraDir = new File(dataDir + "\\camera\\raw");
        if (cameraDir.exists() && cameraDir.isDirectory()) {
            verifyResult.setCameraFilePicNum(cameraDir.listFiles().length);
        }

        File workframeFile = new File(dataDir + "\\meta-data\\workAxesFrame.json");
        verifyResult.setWorkFrameFileExist(workframeFile.exists());

        File missionFile = new File(dataDir + "\\meta-data\\mission.json");
        verifyResult.setMissionFileExist(missionFile.exists());

        File recordFile = new File(dataDir + "\\meta-data\\record.json");
        verifyResult.setRecordFileExist(recordFile.exists());

        File cameraXmlFile = new File(dataDir + "\\camera\\" + verifyTarget.getTargetName() + ".xml");
        boolean isCameraXmlExist = cameraXmlFile.exists();
        verifyResult.setCameraXmlExist(isCameraXmlExist);

        if (isCameraXmlExist) {
            PicXmlObjParser picXmlObjParser = new PicXmlObjParser();
            picXmlObjParser.initXml(cameraXmlFile.getAbsolutePath());
            verifyResult.setCameraXmlPicNum(picXmlObjParser.calPictureNum());
        } else {
            verifyResult.setCameraXmlPicNum(0);
        }
        logger.info("*** verifyResult is :" + verifyResult);

        return verifyResult;
    }

    public VerifyTarget getVerifyTarget() {
        return verifyTarget;
    }

    public void setVerifyTarget(VerifyTarget verifyTarget) {
        this.verifyTarget = verifyTarget;
    }
}
