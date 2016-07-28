/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.util</p>
 * <p>File：ToastUtil.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/15:16.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.bob.t.base.TApplication;

/**<p>Class：com.bob.t.util.ToastUtil</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/15:16
 * @version 1.0.0
 */

public class ToastUtil {


    /**
     *  显示信息
     * @param message
     */
    public static  void show(String message){
        Toast.makeText(TApplication.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT ).show();
    }

    /**
     *  显示信息
     * @param message
     */
    public static  void show(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT ).show();
    }

    /**
     * 显示信息
     * @param message
     */
    public static void show(@StringRes int message){
        Toast.makeText(TApplication.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT ).show();
    }

    /**
     * 显示信息
     * @param message
     */
    public static void show(Context context, @StringRes int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT ).show();
    }



}
