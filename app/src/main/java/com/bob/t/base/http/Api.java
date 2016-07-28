/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.http</p>
 * <p>File：Api.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/16:06.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.http;


import okhttp3.Call;

/**<p>Class：com.bob.t.base.http.Api</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/16:06
 * @version 1.0.0
 */

public interface Api {

    /**
     * 获取指定服务
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T createApi( Class<T> clazz);


    /**
     * 获取OkHttpClient
     * @return
     */
    Call.Factory callFactory();
}
