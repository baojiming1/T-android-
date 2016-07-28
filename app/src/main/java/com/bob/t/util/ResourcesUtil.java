package com.bob.t.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.WindowManager;

import com.bob.t.R;


/**
 * <p>名称：com.bob.myclient.util.ResourcesUtil</p>
 * <p>描述：</p>
 * <pre>
 *
 * </pre>
 *
 * @author 鲍建明
 * @version 2.1.0
 * @date 2015/7/31/11:27
 */

public class ResourcesUtil {

    protected static String TAG = ResourcesUtil.class.getName();

    /**
     * 获取资源文件中的颜色资源
     * @param context
     * @param color
     * @return
     */
    public static int getColor(Context context,@ColorRes int color){
        return context.getResources().getColor(color);
    }

    /**
     * 获取资源的图片资源
     * @param context
     * @param drawable
     * @return
     */
    public static Drawable getDrawable(Context context, @DrawableRes int drawable){
        return context.getResources().getDrawable(drawable, null);
    }


    /**
     * 获取字符串资源
     * @param context
     * @param str
     * @return
     */
    public static String getString(Context context, @StringRes int str){
        return context.getString(str);
    }

    /**
     * 根据资源名称获取其ID
     * @param context
     * @param name
     * @param defType
     * @param defPackage
     * @return
     */
    public static int getIdentifier(Context context, String name, String defType, String defPackage){
       return  context.getResources().getIdentifier(name, defType, defPackage);
    }

    /**
     * 获取DimenRes资源
     * @param context
     * @param dimen
     * @return
     */
    public static int getDimens(Context context, @DimenRes int dimen){
        return context.getResources().getDimensionPixelSize(dimen);
    }


    /**
     * 获取设备唯一标识符
     * @return
     */
    public static String getDeviceId(Context context){
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getDeviceId();
    }

    /**
     * 获取版本包名
     * @param mContext
     * @return
     */
    public static String getVersionName(Context mContext){
        String versionName = "";
        try {
            versionName = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(TAG, "获取版本包名失败", e);
        }
        return versionName;
    }

    /**
     * 获取屏幕的高和宽 Point
     * @param mContext
     * @return
     */
    public static Point getPoint(Context mContext){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Point outSize = new Point();
        wm.getDefaultDisplay().getSize(outSize);
        return outSize;
    }

    /**
     * 获取资源中的字符串数组
     * @param mContext
     * @param id
     * @return
     */
    public static String[] getStringArray(Context mContext, @ArrayRes int id){
        return mContext.getResources().getStringArray(id);
    }

    /**
     * 获取16:9的比例尺寸
     * @param size
     * @return
     */
    public static int getProportion_16_9(int size){
        if( size == 0){
            return size;
        }
        int base = size / 16;
        return base * 9;
    }

    /**
     * 获取ColorPrimary 颜色值
     * @param mContext
     * @return
     */
    public static int getColorPrimary(Context mContext){
        TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }


    /**
     * dip转px
     */
    public static int dipToPx(Context context, float dip) {
        return (int) (dip * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * px转dip
     */
    public static int pxToDip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}



