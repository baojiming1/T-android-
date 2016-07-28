/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.http</p>
 * <p>File：SimpleApi.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/16:06.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.http;


import com.bob.t.config.Setting;
import com.bob.t.config.TConfig;
import com.bob.t.util.CollectionUtils;
import com.bob.t.util.StringUtil;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**<p>Class：com.bob.t.base.http.SimpleApi</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/16:06
 * @version 1.0.0
 */

public class SimpleApi implements Api {

    private static final String TAG = SimpleApi.class.getName();
    private Retrofit mRetrofit;

    public SimpleApi(){
        if( mRetrofit == null){
            mRetrofit = createRetrofit();
        }
    }
    /**
     * 初始化OkHttpClient
     * @return
     */
    protected OkHttpClient initOkHttpClient(){
        Setting mSetting = TConfig.getSetting();
        OkHttpClient.Builder mBuilder = new OkHttpClient.Builder().connectTimeout(mSetting.http_timeout, TimeUnit.MILLISECONDS)
                .readTimeout(mSetting.read_timeout, TimeUnit.MILLISECONDS)
                .writeTimeout(mSetting.write_timeout, TimeUnit.MILLISECONDS)
                ;
        if(StringUtil.isNotEmpty(mSetting.cacheFilePath)){
            File cacheFile = new File( mSetting.cacheFilePath);
            Cache cache = new Cache(cacheFile, mSetting.cacheSize);
            mBuilder.cache(cache);
        }
        if( mSetting.isDebug ){
            HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
            mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            mBuilder.addInterceptor(mHttpLoggingInterceptor);
        }
        List<Interceptor> interceptors = initInterceptors();
        if(CollectionUtils.isNotEmpty(interceptors)){
            for (Interceptor interceptor : interceptors) {
                mBuilder.addInterceptor(interceptor);
            }
        }
        return mBuilder.build();
    }

    /**
     * 定义以拦截器
     * @return
     */
    protected List<Interceptor> initInterceptors(){
        return null;
    }



    /**
     * 创建一个service服务
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T createApi( Class<T> clazz) {
           /*       2.0  */
        if( mRetrofit == null){
            synchronized( this ){
                if( mRetrofit == null){
                    mRetrofit = createRetrofit();
                }
            }
        }
        return mRetrofit.create(clazz);
    }

    @Override
    public Call.Factory callFactory() {
        return mRetrofit.callFactory();
    }

    /**
     *
     * @return
     */
    protected Retrofit createRetrofit(){
        OkHttpClient mOkHttpClient = initOkHttpClient();
        return  new Retrofit.Builder().baseUrl(TConfig.getSetting().host)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();
    }


}
