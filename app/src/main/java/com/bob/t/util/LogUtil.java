/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.util</p>
 * <p>File：LogUtil.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/11:36.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.util;

import android.util.Log;

import com.bob.t.config.TConfig;

/**<p>Class：com.bob.t.util.LogUtil</p>
 * <p>Description：</p>
 * <pre>
 *      日志打印工具类
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/11:36
 * @version 1.0.0
 */
public class LogUtil {

    /**
     * 不输出
     */
    public static final int NOTHING = 8;

    static int current_level = TConfig.getSetting().logLevel;



    /**
     * error
     * @param tag
     * @param message
     */
    public static void e(String tag, String message){
        if( current_level >= Log.ERROR)
            Log.e(tag, message);
    }

    /**
     * error
     * @param tag
     * @param msg
     * @param tr
     */
    public static void e(String tag, String msg, Throwable tr) {
        if( current_level >= Log.ERROR)
            Log.e(tag, msg, tr);
    }

    /**
     * info
     * @param tag
     * @param message
     */
    public static void i(String tag, String message){
        if( current_level >= Log.INFO)
            Log.i(tag, message);
    }

    /**
     * debug
     * @param tag
     * @param message
     */
    public static void d(String tag, String message){
        if( current_level >= Log.DEBUG)
            Log.d(tag, message);
    }

    /**
     * verbose
     * @param tag
     * @param message
     */
    public static void v(String tag, String message){
        if( current_level >= Log.VERBOSE)
            Log.v(tag, message);
    }

    /**
     * warn
     * @param tag
     * @param message
     */
    public static void w(String tag, String message){
        if( current_level >= Log.WARN)
            Log.w(tag, message);
    }


}
