/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.mvp</p>
 * <p>File：TListPresenter.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/17:14.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.mvp;

import android.support.annotation.NonNull;

import com.bob.t.base.bean.JsonMessage;
import com.bob.t.base.builder.RequestBodyBuilder;
import com.bob.t.base.listener.OnHttpSendBeforeListener;
import com.bob.t.base.rx.RxSubscriber;

import okhttp3.Request;
import rx.Observer;

/**<p>Class：com.bob.t.base.mvp.TListPresenter</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/17:14
 * @version 1.0.0
 */

public class TListPresenter<T> extends TBasePresenter<TListView> {

    protected TListModel<T> listModel;
    protected TListView view;

    public TListPresenter(@NonNull TListView<T> view) {
        super(view);
        this.view = view;
        this.listModel = getListModel();
    }

    @Override
    public void onStart() {
    }

    /**
     * 请求
     * @param listener
     */
    public void sendList( OnHttpSendBeforeListener listener, int pageNow, int pageSize ){
        RequestBodyBuilder mRequestBodyBuilder = RequestBodyBuilder.create().setPageNow(pageNow).setPageSize(pageSize);
        Request mRequest = listener.buildRequest(new Request.Builder(), mRequestBodyBuilder);
        if(mRequest != null){
            manager.add(
                        listModel.sendList(mRequest, listener.getMainReturnType(), listener.getReturnClass())
                        .subscribe(   observer() )
                        );
        }
    }


    /**
     * 可自定义类型时，请重写改方法
     * @return
     */
    protected Observer<? super T> observer(){
        return (Observer<? super T>) new RxSubscriber<T>(){
            @Override
            public void onSuccess(JsonMessage<T> message) {
                view.addData(message.getRows());
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

    /**
     * 可重写
     * @return
     */
    protected TListModel<T> getListModel(){
        return new TListModel<T>();
    }

}
