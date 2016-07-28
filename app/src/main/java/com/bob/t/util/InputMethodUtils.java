package com.bob.t.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


/**<p>Class：com.tp.venus.util.ReflectUtils</p>
 * <p>Description：</p>
 * <pre>
 *
 *     显示键盘d工具类
 * </pre>
 * @author 鲍建明
 * @date 2015/10/9/18:23
 * @version 1.0.0
 */
public class InputMethodUtils {

    private static InputMethodUtils instance = null;

    public static synchronized InputMethodUtils getInstance(){
        if( instance == null ){
            instance = new InputMethodUtils();
        }
        return instance;
    }

    InputMethodUtils(){}

    /**
     * 显示软键盘
     * @param view
     */
    public void showInputMethod(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                                                          .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    /**
     * 隐藏软键盘
     * @param view
     */
    public void hideInputMethod(View view){
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if( imm != null ){
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
        }
    }

    /**
     * 显示软键盘
     * @param context
     */
    public void showInputMethod(Context context) {
        InputMethodManager imm = (InputMethodManager) context
            .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 多少时间后显示软键盘
     * @param view
     * @param delayMillis
     */
    public void showInputMethod(final View view, long delayMillis) {
        // 显示输入法
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                showInputMethod(view);
            }
        }, delayMillis);
    }
}
