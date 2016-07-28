/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.fragment</p>
 * <p>File：OnHttpSendBeforeListener.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/1/16:07.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.listener;


import com.bob.t.base.builder.RequestBodyBuilder;

import java.lang.reflect.Type;

import okhttp3.Request;

/**<p>Class：com.bob.t.base.listener.OnHttpSendBeforeListener</p>
 * <p>Description：</p>
 * <pre>
 *发送请求前的处理事件
 * </pre>
 * @author 鲍建明
 * @date 2016/6/1/16:07
 * @version 1.0.0
 */

public interface OnHttpSendBeforeListener {

    /**
     * 构建Request.Builder
     * @return
     */
    Request buildRequest(Request.Builder builder, RequestBodyBuilder mRequestBodyBuilder);

    /**
     *  返回值子类型
     * @return
     */
    Type getReturnClass();

    /**
     * 主的Type
     * @return
     */
    Type getMainReturnType();
}
