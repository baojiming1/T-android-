/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.base.builder</p>
 * <p>File：RequestBodyBuilder.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2015/10/13/14:53.</p>
 * Copyright © 2015 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.builder;

import android.support.annotation.Nullable;

import com.bob.t.util.CollectionUtils;
import com.bob.t.util.LogUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.ByteString;

/**<p>Class：com.tp.venus.base.builder.RequestBodyBuilder</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2015/10/13/14:53
 * @version 1.0.0
 */

public class RequestBodyBuilder {

    public final static String PAGE_NOW_FIELD = "pageNow";
    public final static String PAGE_SIZE_FIELD = "pageSize";

    protected static final String TAG = RequestBodyBuilder.class.getName();


    private Map<String, Object> params;

    private MediaType mMediaType;
    private String body;
    private Object bean;

    public static RequestBodyBuilder create(){
        return new RequestBodyBuilder();
    }

    private RequestBodyBuilder(){
        this.mMediaType = MediaType.parse("application/json;charset=UTF-8");
        this.params = new HashMap<>();
    }

    /**
     * 设置参数
     * @param body
     * @return
     */
    public RequestBodyBuilder setStringBody(String body){
        this.body = body;
        this.params.clear();
        this.bean = null;
        return this;
    }

    /**
     * 设置参数
     * @param bean
     * @return
     */
    public RequestBodyBuilder setBeanBody(Object bean){
        this.bean = bean;
        this.params.clear();
        this.body = null;
        return this;
    }

    /**
     * 构建
     * @return
     */
    public RequestBody build(){
        String body = getJsonString();
        LogUtil.d(TAG, body);
        return RequestBody.create(mMediaType, ByteString.encodeUtf8(body));
    }

    /**
     * 构建get请求参数
     * @param url
     * @return
     */
    public String buildGet(String url){
        return getParamString(url);
    }


    /**
     * 当前页
     * @param pageNow
     * @return
     */
    public RequestBodyBuilder setPageNow(int pageNow){
        this.params.put(PAGE_NOW_FIELD, pageNow);
        return this;
    }

    /**
     * 每页纪录数
     * @param pageSize
     * @return
     */
    public RequestBodyBuilder setPageSize(int pageSize){
        this.params.put(PAGE_SIZE_FIELD, pageSize);
        return this;
    }

    /**
     * 获取pageSize
     * @return
     */
    public int getPageSize(){
        Object obj = this.params.get(PAGE_SIZE_FIELD);
        if(obj == null){
            return 0;
        }
        return (int)obj;
    }

    /**
     * 获取pageNow
     * @return
     */
    public int getPageNow(){
        Object obj = this.params.get(PAGE_NOW_FIELD);
        if( obj == null){
            return 0;
        }
        return  (int)obj;
    }

    /**
     * 下一页
     * @return
     */
    public RequestBodyBuilder nextPage(){
        int pageNow = getPageNow();
        this.params.put(PAGE_NOW_FIELD, pageNow  + 1);
        return this;
    }


    /**
     * 设置参数
     * @param key
     * @param value
     * @return
     */
    public RequestBodyBuilder setParam(String key, Object value){
        this.params.put(key, value);
        return this;
    }

    /**
     * 设置参数
     * @param params
     * @return
     */
    public RequestBodyBuilder setParams(Map<String, Object> params){
        this.params.putAll(params);
        return this;
    }


    /**
     * 获取 JSON data
     * @return
     */
    private String getJsonString(){
        if( CollectionUtils.isMapNotEmpty(this.params) ){
            return new Gson().toJson(params);
        }
        if( bean != null ){
            return new Gson().toJson(bean);
        }
        return body;
    }

    /**
     * 设置get请求的url参数
     * @return
     */
    private String getParamString(@Nullable String url){
        StringBuffer sb = new StringBuffer(url);
        if( url.contains("?") ){   //已经带有参数了
            sb.append("&");
        } else {            //没有带参数
            sb.append("?");
        }
        if( CollectionUtils.isMapNotEmpty(this.params) ){
            for (Map.Entry<String,Object> entry : params.entrySet()  ){
                sb.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }


}
