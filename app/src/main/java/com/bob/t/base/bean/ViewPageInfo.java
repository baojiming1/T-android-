/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.base.adapter</p>
 * <p>File：ViewPageInfo.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/1/26/12:17.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.bean;

import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**<p>Class：com.tp.venus.base.adapter.ViewPageInfo</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/1/26/12:17
 * @version 1.0.0
 */

public class ViewPageInfo {

    @IntDef({ViewPageInfo.TEXT, ViewPageInfo.ICON, ViewPageInfo.VIEW })
    @Retention(RetentionPolicy.SOURCE)
    public @interface PageInfoType{}

    //文体标题
    public static final int TEXT = 0X001;
    //图片标题
    public static final int ICON = 0X002;
    //自定义View
    public static final int VIEW = 0X003;

    public Fragment mFragment;
    public  String title;
    public  @DrawableRes
    int icon_sel;
    public  @DrawableRes
    int icon_nor;
    public View view;
    public int infoType;

    public ViewPageInfo(String title, Fragment mFragment, @PageInfoType int infoType) {
        this.mFragment = mFragment;
        this.title = title;
        this.infoType = infoType;
    }

    public ViewPageInfo(int icon_nor, Fragment mFragment, @PageInfoType int infoType) {
        this.icon_nor = icon_nor;
        this.mFragment = mFragment;
        this.infoType = infoType;
    }

    public ViewPageInfo(int icon_nor, int  icon_sel, Fragment mFragment, @PageInfoType int infoType) {
        this.icon_sel = icon_sel;
        this.icon_nor = icon_nor;
        this.mFragment = mFragment;
        this.infoType = infoType;
    }

    public ViewPageInfo(View view, Fragment mFragment, @PageInfoType int infoType) {
        this.view = view;
        this.mFragment = mFragment;
        this.infoType = infoType;
    }



}
