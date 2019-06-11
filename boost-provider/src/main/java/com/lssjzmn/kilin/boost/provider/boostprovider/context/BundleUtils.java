package com.lssjzmn.kilin.boost.provider.boostprovider.context;

import java.util.Locale;
import java.util.ResourceBundle;

public class  BundleUtils {


    private static ResourceBundle defaultBundle;

    private static ResourceBundle curBundle;



    public static void initResourceBundle(){
        Locale localeUS = Locale.US;
        Locale localeCN = Locale.CHINA;
        Locale defaultLocale = Locale.getDefault();
        //通过ResourceBundle工具类绑定资源文件(包名.文件名(基本名称不包括语言部分和后缀部分))
        defaultBundle = ResourceBundle.getBundle("client_language", localeUS);
        curBundle=ResourceBundle.getBundle("client_language", localeCN);
    }




    public static String getString(String key){

        String value=curBundle.getString(key);

        return value;
    }
}
