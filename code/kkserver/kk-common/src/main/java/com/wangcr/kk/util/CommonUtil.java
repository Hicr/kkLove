package com.wangcr.kk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class CommonUtil {


    /**
     * base64编码
     *
     * @param src
     * @return
     */
    public static String base64Encode(byte[] src) {
        return Base64.getEncoder().encodeToString(src);
    }

    /**
     * base64解码
     * @param src
     * @return
     */
    public static byte[] base64Decode(String src) {
        return Base64.getDecoder().decode(src);
    }

    /**
     * URL编码
     *
     * @param str
     * @param charSet
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String urlEncode(String str, String charSet) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        return URLEncoder.encode(str, charSet);
    }

    /**
     * URL解码
     *
     * @param str
     * @param charSet
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String urlDecode(String str, String charSet) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        return URLDecoder.decode(str, charSet);
    }

}
