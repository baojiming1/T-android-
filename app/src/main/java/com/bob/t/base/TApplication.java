/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base</p>
 * <p>File：TApplication.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/16:09.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base;

import android.app.Application;

import com.bob.t.base.http.SimpleApi;
import com.bob.t.config.TConfig;

/**<p>Class：com.bob.t.base.TApplication</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/16:09
 * @version 1.0.0
 */

public class TApplication extends Application {

    private static TApplication instance = null;

    public static synchronized TApplication getInstance(){
        if( instance == null){
            instance = new TApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //TODO 此处不能写，打包上传后删除
        TConfig.init(true).setHost("http://nine.api.qbt365.com/")
                .setApi(new SimpleApi())
                .build();
    }
}
