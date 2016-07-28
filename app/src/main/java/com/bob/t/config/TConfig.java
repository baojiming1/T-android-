/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.config</p>
 * <p>File：TConfig.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/15:56.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.config;

/**<p>Class：com.bob.t.config.TConfig</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/15:56
 * @version 1.0.0
 */

public class TConfig {

    private static final Setting mSetting = new Setting();


    public static Setting.Builder init(boolean isDebug){
        return mSetting.newBuilder().setDevelopModel(isDebug);
    }


    public static Setting getSetting(){
        return mSetting;
    }

}
