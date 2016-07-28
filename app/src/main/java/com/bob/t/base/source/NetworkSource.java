/**
 * <p>Project：T</p>
 * <p>Package：	com.bob.t.base.source</p>
 * <p>File：NetworkSource.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/7/27/17:49.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.source;

import com.bob.t.base.http.Api;
import com.bob.t.base.rx.RxSchedulers;
import com.bob.t.config.TConfig;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Request;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**<p>Class：com.bob.t.base.source.NetworkSource</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/7/27/17:49
 * @version 1.0.0
 */

public class NetworkSource<T> implements DataSource<T> {

    protected Request request;
    protected Type mainType;
    protected Type subType;

    public NetworkSource(Request request,  Type mainType,  Type subType ){
        this.request = request;
        this.mainType = mainType;
        this.subType = subType;
    }

    @Override
    public  Observable<T> getData() {
        return Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Call mCall = null;
                try {
                    mCall = getApi().callFactory().newCall(request);
                    String str = mCall.execute().body().string();
                    if (!mCall.isCanceled()) {
                        subscriber.onNext(str);
                    }
                } catch (Exception e) {
                    if (!mCall.isCanceled()) {
                        subscriber.onError(e);
                    }
                    return ;
                }
                if (!mCall.isCanceled()) {
                    subscriber.onCompleted();
                }
            }
        }).flatMap(new Func1<String, Observable<T>>() {
            @Override
            public Observable<T> call(String response) {
                ParameterizedType mParameterizedType = getParameterizedType(mainType, subType);
                T t = new Gson().fromJson(response, mParameterizedType);
                return  Observable.just( t );
            }
        }).compose(RxSchedulers.<T>io_main());
    }


    protected ParameterizedType getParameterizedType(final Type mainType, final Type... subType){

        return new ParameterizedType(){

            @Override
            public Type[] getActualTypeArguments() {
                return subType;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }

            @Override
            public Type getRawType() {
                return mainType;
            }
        };
    }

    protected Api getApi(){
        return TConfig.getSetting().api;
    }
}
