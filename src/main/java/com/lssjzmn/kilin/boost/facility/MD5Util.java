package com.lssjzmn.kilin.boost.facility;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {


    public static boolean validateImage(String fileName, String md5) {
        File file = new File(fileName);
        InputStream fileIn = null;
        byte[] buffer = new byte[1024];
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int numRead = 0;
        try {
            fileIn = new FileInputStream(file);
            BufferedInputStream in = new BufferedInputStream(fileIn);
            while ((numRead = fileIn.read(buffer)) > 0) {
                messagedigest.update(buffer, 0, numRead);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] md5Byte = messagedigest.digest();
        String md5Text = bufferToHex(md5Byte, 0, md5Byte.length);
        if (md5Text.equals(md5)) {
            return true;
        } else {
            return false;
        }
    }


    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
}
