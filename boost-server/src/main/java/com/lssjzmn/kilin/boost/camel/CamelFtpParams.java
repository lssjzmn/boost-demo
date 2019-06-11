package com.lssjzmn.kilin.boost.camel;

import com.lssjzmn.kilin.boost.context.DynamicParameter;
import com.lssjzmn.kilin.boost.facility.DataHomeUtil;

public class CamelFtpParams {

    public static final String CAMERA_TYPE = "CAMERA_TYPE";
    public static final String RADAR_TYPE = "RADAR_TYPE";
    public static final String METADATA_TYPE = "METADATA_TYPE";
    public static final String SERVERLOG_TYPE = "SERVERLOG_TYPE";

    public static final String cameraFtpInfoHead = DynamicParameter.getInstance().getCameraFtpInfoHead();
    public static final String cameraXmlFtpInfoHead = DynamicParameter.getInstance().getCameraXmlFtpInfoHead();
    public static final String radarFtpInfoHead = DynamicParameter.getInstance().getRadarFtpInfoHead();
    public static final String metadataFtpInfoHead = DynamicParameter.getInstance().getMetadataFtpInfoHead();

    public static final String cameraFtpInfoTail = DynamicParameter.getInstance().getCameraFtpInfoTail();
    public static final String cameraXmlFtpInfoTail = DynamicParameter.getInstance().getCameraXmlFtpInfoTail();
    public static final String radarFtpInfoTail = DynamicParameter.getInstance().getRadarFtpInfoTail();
    public static final String metadataFtpInfoTail = DynamicParameter.getInstance().getMetadataFtpInfoTail();

    public static final String serverlogFtpInfo = "ftp://192.168.2.10/server-main-log?username=guimuradar&password=guimuradar&binary=true&recursive=true&fastExistsCheck=true&passiveMode=true&delay=160s&noop=true&idempotent=true";

    public static final String TEST_TYPE = "TEST_TYPE";
    public static final String testcameraFtpInfo = "ftp://home.gm-robot.com/testcamera/88888_99999/camera/raw?username=gmswap&password=guimuswap&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&noop=true&idempotent=true&delay=15s";
    public static final String testcameraXmlFtpInfo2 = "ftp://home.gm-robot.com/testcamera/88888_99999?username=gmswap&password=guimuswap&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&noop=true&idempotent=true&delay=15s";
    public static final String testradarFtpInfo3 = "ftp://home.gm-robot.com/testradar/88888_99999?username=gmswap&password=guimuswap&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&noop=true&idempotent=true&delay=15s";
    public static final String testmetadataFtpInfo3 = "ftp://home.gm-robot.com/testmetadata/88888_99999?username=gmswap&password=guimuswap&binary=true&autoCreate=true&recursive=true&fastExistsCheck=true&passiveMode=true&noop=true&idempotent=true&delay=15s";


    public String localDir = "file:D:/detectData";

    public String getLocalDirFromEnv() {
        localDir = "file:" + DataHomeUtil.getDetectDataHome();
        return localDir;
    }
}
