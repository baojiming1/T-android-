/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.rx</p>
 * <p>File：RxSubscriber.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/1/14:15.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.rx;

import android.util.Log;

import com.bob.t.base.bean.JsonMessage;
import com.bob.t.config.TConfig;
import com.bob.t.util.LogUtil;
import com.bob.t.util.ToastUtil;

import rx.Subscriber;

/**<p>Class：com.bob.t.base.rx.RxSubscriber</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/1/14:15
 * @version 1.0.0
 */

public abstract class RxSubscriber<T>  extends Subscriber<JsonMessage<T>> {

    protected static final String TAG = RxSubscriber.class.getName();

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {
        paraseThrowable(throwable);
    }

    protected void paraseThrowable(Throwable e){
        LogUtil.e(TAG, "数据解析错误", e);
        if(TConfig.getSetting().logLevel == Log.DEBUG){
            e.printStackTrace();
        }
      /*  if( e instanceof ConnectException){
            return "无法连接网络，请重试";
        } else if( e instanceof SocketTimeoutException){
            return "网络连接超时，请重试";
        }
        return "数据解析错误";*/
    }

    @Override
    public void onNext(JsonMessage<T> tJsonMessage) {
        int code = tJsonMessage.getCode();
        if( code == 200 ){
            onSuccess(tJsonMessage);
        } else if( code == 403){             //无权操作
            authenticationFail(tJsonMessage);
        } else {
            onFail(tJsonMessage);
        }
    }


    public abstract void onSuccess(JsonMessage<T>  message);


    protected void onFail(JsonMessage<T> jsonMessage){
        if( jsonMessage == null){
            ToastUtil.show("请求数据为空");
        } else {
            ToastUtil.show(jsonMessage.getMessage());
        }

    }

    /** 无权限操作 **/
    protected boolean authenticationFail(JsonMessage<T> jsonMessage){
        return false;
    }
}
