/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.rx</p>
 * <p>File：RxBusManager.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/11:21.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.rx;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**<p>Class：com.bob.t.base.rx.RxBusManager</p>
 * <p>Description：</p>
 * <pre>
 *      Rxjava管理器
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/11:21
 * @version 1.0.0
 */

public class RxBusManager {

    public RxBus mRxBus = RxBus.$();
    private Map<String, Observable<?>> mObservables = new HashMap<>();// 管理观察者
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();// 管理订阅者者


    public void on(String eventName, Action1<Object> action1) {
        Observable<?> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName, mObservable);
        mCompositeSubscription.add(mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }));
    }

    /**
     * 添加订阅者者
     * @param m
     */
    public void add(Subscription m) {
        mCompositeSubscription.add(m);
    }

    /**
     * 清空观察者、订阅者
     */
    public void clear() {
        mCompositeSubscription.unsubscribe();// 取消订阅
        for (Map.Entry<String, Observable<?>> entry : mObservables.entrySet()) {
            mRxBus.unregister(entry.getKey(), entry.getValue());// 移除观察
        }
    }

    /**
     * post事件
     * @param tag
     * @param content
     */
    public void post(Object tag, Object content) {
        mRxBus.post(tag, content);
    }

}
