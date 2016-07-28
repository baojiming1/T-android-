/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.config</p>
 * <p>File：HttpSetting.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/15:12.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.config;

import android.util.Log;

import com.bob.t.base.http.Api;
import com.bob.t.util.LogUtil;
import com.bob.t.util.StringUtil;

/**<p>Class：com.bob.t.config.HttpSetting</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/15:12
 * @version 1.0.0
 */

public class Setting {

    public boolean isDebug;     //开发模式
    public int http_timeout;       //连接超时
    public int read_timeout;       //读取超时
    public int write_timeout;      //写入超时
    public String cacheFilePath ;       //http cache 文件目录
    public int cacheSize;            //http cache 大小
    public String host;             //基础服务地址
    public int logLevel = Log.VERBOSE;          //Log级别
    public Api api ;                     //http 具体实现

    Setting(){
        this.isDebug = false;
        this.http_timeout = 3000;
        this.read_timeout = 3000;
        this.write_timeout = 3000;
        this.logLevel = Log.VERBOSE;
    }

    public Builder newBuilder(){
        return new Builder(this);
    }


    public class Builder{

        private Setting mSetting;

         Builder(Setting mSetting){
            this.mSetting = mSetting;
        }

        /**
         * 设置开发模式
         * @param isDebug
         * @return
         */
        public Builder setDevelopModel(boolean isDebug){
            mSetting.isDebug = isDebug;
            if( isDebug ){
                mSetting.logLevel = Log.DEBUG;
            } else {
                mSetting.logLevel = LogUtil.NOTHING;
            }
            return this;
        }

        /**
         * 设置HTTP超时
         * @param http_timeout
         * @return
         */
        public Builder setHttp_timeout(int http_timeout) {
            mSetting.http_timeout = http_timeout;
            return this;
        }

        /**
         * 设置HTTP缓存
         * @param cacheFilePath
         * @param cacheSize
         * @return
         */
        public Builder setHttpCache(String cacheFilePath, int cacheSize){
            mSetting.cacheFilePath = cacheFilePath;
            mSetting.cacheSize = cacheSize;
            return this;
        }

        /**
         * 设置日志模式
         * @param logLevel
         * @return
         */
        public Builder setLogLevel(int logLevel){
            mSetting.logLevel = logLevel;
            return this;
        }

        /**
         * 设置HTTP写入超时
         * @param write_timeout
         * @return
         */
        public Builder setWrite_timeout(int write_timeout) {
            mSetting.write_timeout = write_timeout;
            return this;
        }

        /**
         * 设置HTTP读取超时
         * @param read_timeout
         * @return
         */
        public Builder setRead_timeout(int read_timeout) {
            mSetting.read_timeout = read_timeout;
            return this;
        }

        /**
         * 设置HTTP base url
         * @param host
         * @return
         */
        public Builder setHost(String host) {
            mSetting.host = host;
            return this;
        }

        /**
         * 设置http 具体实现
         * @param api
         * @return
         */
        public Builder setApi(Api api) {
            mSetting.api = api;
            return this;
        }

        public Setting build(){
            if(StringUtil.isEmpty( host )){
                throw new NullPointerException("Setting class host field is null");
            }
            if( api == null ){
                throw new NullPointerException("Api is null object");
            }
            return mSetting;
        }

    }


}
