/**
 * <p>Project：nine_android</p>
 * <p>Package：	com.tp.venus.util</p>
 * <p>File：DoubleUtils.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/4/21/14:19.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.util;

import java.math.BigDecimal;

/**<p>Class：com.tp.venus.util.DoubleUtils</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/4/21/14:19
 * @version 1.0.0
 */

public class DoubleUtils {

    private static DoubleUtils instance = null;

    public static synchronized DoubleUtils getInstance(){
        if( instance == null ){
            instance = new DoubleUtils();
        }
        return instance;
    }

    DoubleUtils(){}


    /**
     * 默认保留2位数
     */
    private  final int SCALE_NUM = 2;


    /**
     * 数值保留两位小数
     *
     * @param dou
     *            转换前数值
     * @return 转换后字符串
     */
    public  String toString(Double dou) {
        return toString(String.valueOf(dou), SCALE_NUM);
    }

    /**
     * 数值保留两位小数
     * @param sDouble
     * @return 没有返回0.00d
     */
    public  Double toDouble(String sDouble){
        return toDouble(toString(sDouble, SCALE_NUM), 0.00d);
    }

    /**
     * 字符串转double
     * @param value
     * @param defaultValue
     * @return
     */
    public Double toDouble(String value, double defaultValue){
        if( StringUtil.isEmpty(value)){
            return defaultValue;
        }
        try {
            return Double.parseDouble(value);
        } catch (Exception e){
        }
        return defaultValue;
    }

    /**
     * 字符串转int
     * @param value
     * @param defaultValue
     * @return
     */
    public Integer toInteger(String value, int defaultValue){
        if( StringUtil.isEmpty(value)){
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (Exception e){
        }
        return defaultValue;
    }




    /**
     * 数值保留二位小数
     * @param sFloat
     * @return 没有返回0.00f
     */
    public  Float toFloat(String sFloat){
        return toFloat(toString(sFloat, SCALE_NUM), 0.00f);
    }

    /**
     * 字符串转Float
     * @param value
     * @param defaultValue
     * @return
     */
    public Float toFloat(String value, float defaultValue){
        if( StringUtil.isEmpty(value)){
            return defaultValue;
        }
        try {
            return Float.parseFloat(value);
        } catch (Exception e){
        }
        return defaultValue;
    }


    /**
     * 相加，返回保留后的2位数值
     * @param dou1
     * @param dou2
     * @return 没有返回0.00f
     */
    public Double add(String dou1, String dou2){
        BigDecimal b = new BigDecimal(dou1);
        BigDecimal b2 = new BigDecimal(dou2);
        return toDouble(b.add(b2).toString());
    }

    /**
     * 相加，返回保留后的2位数值
     * @param dou1
     * @param dou2
     * @return
     */
    public String addToString(String dou1, String dou2){
        BigDecimal b = new BigDecimal(dou1);
        BigDecimal b2 = new BigDecimal(dou2);
        return b.add(b2).toString();
    }




    /**
     * 相加，返回保留后的2位数值
     * @param dou1
     * @param dou2
     * @return 没有返回0.00f
     */
    public BigDecimal add(BigDecimal dou1, BigDecimal dou2){
        return toBigDecimal(dou1.add(dou2).toString(), SCALE_NUM);
    }


    /**
     * 除法，返回保留后的2位数值，四舍五入
     * @param str1 被除数
     * @param str2 除数
     * @return
     */
    public Double division(String str1, String str2){
        BigDecimal b = new BigDecimal(str1);
        BigDecimal b2 = new BigDecimal(str2);
        return b.divide(b2, SCALE_NUM, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 除法，返回保留后的2位数值，四舍五入
     * @param str1 被除数
     * @param str2 除数
     * @return
     */
    public BigDecimal division(BigDecimal str1, BigDecimal str2){
        return toBigDecimal(str1.divide(str2).toString(), SCALE_NUM);
    }


    /**
     * 乘法，保留2位数值
     * @param str1
     * @param str2
     * @return
     */
    public Double multiply(String str1, String str2){
        BigDecimal b = new BigDecimal(str1);
        BigDecimal b2 = new BigDecimal(str2);
        return toDouble(b.multiply(b2).toString());
    }


    /**
     * 乘法，保留2位数值
     * @param str1
     * @param str2
     * @return
     */
    public BigDecimal multiply(BigDecimal str1, BigDecimal str2){
        return toBigDecimal(str1.multiply(str2).toString(), SCALE_NUM);
    }


    /**
     * 减法，str1 - str2
     * 保留2位数值
     * @param str1
     * @param str2
     * @return
     */
    public Double subtract(String str1, String str2){
        BigDecimal b = new BigDecimal(str1);
        BigDecimal b2 = new BigDecimal(str2);
        return toDouble(b.subtract(b2).toString());
    }


    /**
     * 减法，str1 - str2
     * 保留2位数值
     * @param str1
     * @param str2
     * @return
     */
    public BigDecimal subtract(BigDecimal str1, BigDecimal str2){
        return toBigDecimal(str1.subtract(str2).toString(), SCALE_NUM);
    }



    /**
     * 格式化数字
     * @param str 数字字符串
     * @param length 保留几位数
     * @return
     */
    private String toString(String str, int length){
        if( isNumber(str) ) {
            BigDecimal b = new BigDecimal(str);
            return b.setScale(length, BigDecimal.ROUND_HALF_UP).toString();
        }
        return null;
    }

    /**
     * 格式化数字
     * @param str 数字字符串
     * @param length 保留几位数
     * @return
     */
    private BigDecimal toBigDecimal(String str, int length){
        if( isNumber(str) ) {
            BigDecimal b = new BigDecimal(str);
            return b.setScale(length, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }


    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public boolean isNumber(final String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        final char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // deal with any possible sign up front
        final int start = (chars[0] == '-') ? 1 : 0;
        if (sz > start + 1 && chars[start] == '0') { // leading 0
            if (
                    (chars[start + 1] == 'x') ||
                            (chars[start + 1] == 'X')
                    ) { // leading 0x/0X
                int i = start + 2;
                if (i == sz) {
                    return false; // str == "0x"
                }
                // checking hex (it can't be anything else)
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9')
                            && (chars[i] < 'a' || chars[i] > 'f')
                            && (chars[i] < 'A' || chars[i] > 'F')) {
                        return false;
                    }
                }
                return true;
            } else if (Character.isDigit(chars[start + 1])) {
                // leading 0, but not hex, must be octal
                int i = start + 1;
                for (; i < chars.length; i++) {
                    if (chars[i] < '0' || chars[i] > '7') {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--; // don't want to loop to the last char, check it afterwords
        // for type qualifiers
        int i = start;
        // loop to the next to last char or to the last char if we need another digit to
        // make a valid number (e.g. chars[0..5] = "1234E")
        while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;

            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // we've already taken care of hex.
                if (hasExp) {
                    // two E's
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false; // we need a digit after the E
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // no type qualifier, OK
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                // can't have an E at the last byte
                return false;
            }
            if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                // single trailing decimal point after non-exponent is ok
                return foundDigit;
            }
            if (!allowSigns
                    && (chars[i] == 'd'
                    || chars[i] == 'D'
                    || chars[i] == 'f'
                    || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l'
                    || chars[i] == 'L') {
                // not allowing L with an exponent or decimal point
                return foundDigit && !hasExp && !hasDecPoint;
            }
            // last character is illegal
            return false;
        }
        // allowSigns is true iff the val ends in 'E'
        // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
        return !allowSigns && foundDigit;
    }
}
