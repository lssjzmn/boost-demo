package com.lssjzmn.kilin.boost.facility;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;

public class FilePersistentUtil {

    static Logger logger = LoggerFactory.getLogger(FilePersistentUtil.class);

    private static final String GM_ROBOT_SINGNATURE_JSON = "./config/GM_ROBOT_SINGNATURE.json";
    public static final String CONFIG_DIR = "./config";
    private static final String cacheFileSuffix = ".json";
    private static final String separator = File.separator;

    public static void writeJsonFile(String fileDirAndName, Object object) {
        File dir = new File(CONFIG_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        JSONObject jsonObject = JSONObject.fromObject(object);
        String detectString = jsonObject.toString();
        BufferedWriter writer = null;
        File file = new File(fileDirAndName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            logger.info("IOException！", e);
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
            writer.write(detectString);
        } catch (IOException e) {
            logger.info("IOException！", e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                logger.info("IOException！", e);
            }
        }
        logger.info(object.getClass().getSimpleName() + " 文件写入成功！");
    }

    public static Object getObjectFromJson(Class clazz, String fileDirAndName) {
        if (!new File(fileDirAndName).exists()) {
            logger.error("signature file " + fileDirAndName + " not exists.");
            return null;
        }
        BufferedReader reader = null;
        String jsonStr = "";
        try {
            logger.info("sig file name:" + fileDirAndName);
            FileInputStream fileInputStream = new FileInputStream(fileDirAndName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                jsonStr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            logger.info("IOException！", e);
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.info("IOException！", e);
                }
            }
        }
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(jsonStr);
        return com.alibaba.fastjson.JSONObject.toJavaObject(jsonObject, clazz);
    }

}
