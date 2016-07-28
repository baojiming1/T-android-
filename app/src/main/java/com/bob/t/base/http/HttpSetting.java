/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.http</p>
 * <p>File：HttpSetting.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/18:04.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.http;

/**<p>Class：com.bob.t.base.http.HttpSetting</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/18:04
 * @version 1.0.0
 */

public class HttpSetting {

    private long connectTimeout;
    private long readTimeout;
    private long writeTimeout;
    private String cacheDir;
    private long cacheSize;

    HttpSetting(){}

    public static HttpSetting create(){
        return new HttpSetting();
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public HttpSetting setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public HttpSetting setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public HttpSetting setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public String getCacheDir() {
        return cacheDir;
    }

    public HttpSetting setCacheDir(String cacheDir) {
        this.cacheDir = cacheDir;
        return this;
    }

    public long getCacheSize() {
        return cacheSize;
    }

    public HttpSetting setCacheSize(long cacheSize) {
        this.cacheSize = cacheSize;
        return this;
    }
}
