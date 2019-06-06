package com.lssjzmn.kilin.boost.facility;

import java.util.Iterator;
import java.util.Map;

public class DataHomeUtil {

    private static final String GM_DATA_HOME = "GM_DATA_HOME";

    public static String getDetectDataHome() {
        Map<String, String> map = System.getenv();
        for (Iterator<String> itr = map.keySet().iterator(); itr.hasNext(); ) {
            String key = itr.next();
            if (GM_DATA_HOME.equals(key)) {
                return map.get(key);
            }
        }
        return "D:\\detectData";
    }
}
