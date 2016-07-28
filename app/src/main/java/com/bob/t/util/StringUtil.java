package com.bob.t.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>名称：com.bob.oschinademo.util.StringUtil</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/6/17/11:23
 */

public class StringUtil {

    public static final String EMPTY = "";
    public static final String UTF_8 = "UTF-8";

    /**
     * 编码
     * @param str
     * @return
     */
    public static String encode(String str){
        try {
            return URLEncoder.encode(str, UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解码
     * @param str
     * @return
     */
    public static String decode(String str){
        try {
            return URLDecoder.decode(str, UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String toString(byte[] str){
        try {
            return new String(str, UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断以http 或者 https打头的url
     * @param url
     * @return
     */
    public static boolean isHttp(String url){
        if( isEmpty( url ) ){
            return false;
        }
        if(url.startsWith("http://") || url.startsWith("https://")){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.trim().length() > 0));
    }

    public static boolean equals(String str1, String str2) {
        return (str1 == null ? str2 == null : str1.equals(str2));
    }

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.trim().length() == 0));
    }

    public static String trimToEmpty(final String str) {
        return str == null ? EMPTY : str.trim();
    }


    /**
     * 截取字符串过多的部分用...来标示
     * @param str
     * @param len
     * @return
     */
    public static String splitString(String str, int len){
        if( isEmpty(str) || len == 0){
            return "";
        }
        if(str.length() <= len){
            return str;
        }
        String result = str.substring(0, len);
        return result + "...";
    }

}
