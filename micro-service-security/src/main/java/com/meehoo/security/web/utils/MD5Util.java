package com.meehoo.security.web.utils;

import java.security.MessageDigest;

public class MD5Util {

    private static final String HEX_DIGITS[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param origin      字符
     * @param charsetname 编码
     * @return
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }


    public static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * 获取用户盐值，用于加密用户密码
     *
     * @param loginName
     * @return
     */
    public static String getUserSalt(String loginName) {
        // 盐值
        String[] salts = {"sun", "moon", "star", "sky", "cloud", "fog", "rain", "wind", "rainbow"};
        int hashCode = loginName.hashCode() + 159;
        int mod = Math.abs(hashCode % 9);
        return salts[mod];
    }

    public static String getUserEncryptPassword(String loginName, String password) {
        String pwdAndSalt = password + getUserSalt(loginName);
        return MD5Encode(pwdAndSalt, "utf8");
    }
}
