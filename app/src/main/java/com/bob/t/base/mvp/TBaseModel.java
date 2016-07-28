/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.mvp</p>
 * <p>File：TBaseModel.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/10:31.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.mvp;

import com.bob.t.base.http.Api;
import com.bob.t.config.TConfig;

/**<p>Class：com.bob.t.base.mvp.TBaseModel</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/10:31
 * @version 1.0.0
 */

public class TBaseModel {

    protected Api api;

    public TBaseModel(){
        api = getApi();
    }

    /**
     * Api 服务
     * @return
     */
    protected Api getApi(){
        return TConfig.getSetting().api;
    }

}
