/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：BlPresenter.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/2/13:08.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.p;

import android.support.annotation.NonNull;

import com.bob.t.base.bean.JsonMessage;
import com.bob.t.base.mvp.TListPresenter;
import com.bob.t.base.mvp.TListView;
import com.bob.t.base.rx.RxSubscriber;
import com.bob.t.module.bean.PageResult;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import rx.Observer;

/**<p>Class：com.bob.t.module.p.BlPresenter</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/2/13:08
 * @version 1.0.0
 */

public class BlPresenter<T> extends TListPresenter<T>{


    public BlPresenter(@NonNull TListView<T> view) {
        super(view);
    }

    @Override
    protected Observer<? super T> observer() {
        return (Observer<? super T>) new RxSubscriber<PageResult<T>>(){
            @Override
            public void onSuccess(JsonMessage<PageResult<T>> message) {
                view.addData(message.getObj().getRows());
            }

            @Override
            public void onError(Throwable throwable) {
                view.onError();
                super.onError(throwable);
            }

            @Override
            public void onCompleted() {
                view.onCompleted();
                super.onCompleted();
            }
        };
    }

   protected ParameterizedType type(final Class raw, final Type... args){
       return new ParameterizedType(){
           @Override
           public Type[] getActualTypeArguments() {
               return args;
           }

           @Override
           public Type getOwnerType() {
               return null;
           }

           @Override
           public Type getRawType() {
               return raw;
           }
       };
   }
}
