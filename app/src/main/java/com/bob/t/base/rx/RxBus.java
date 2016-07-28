/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.rx</p>
 * <p>File：RxBus.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/11:21.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.rx;

import android.support.annotation.NonNull;

import com.bob.t.util.CollectionUtils;
import com.bob.t.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**<p>Class：com.bob.t.base.rx.RxBus</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/11:21
 * @version 1.0.0
 */

public class RxBus {

    public static final String TAG = RxBus.class.getName();

    private static RxBus instance;

    public static synchronized RxBus $() {
        if (null == instance) {
            instance = new RxBus();
        }
        return instance;
    }

    private RxBus() {
    }

    private ConcurrentHashMap<Object, List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    /**
     * 订阅事件源
     *
     * @param mObservable
     * @param mAction1
     * @return
     */
    public RxBus OnEvent(Observable<?> mObservable, Action1<Object> mAction1) {
        mObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(mAction1, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return $();
    }

    /**
     * 注册事件源
     *
     * @param tag
     * @return
     */
    public <T> Observable<T> register(@NonNull Object tag) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (CollectionUtils.isEmpty(subjectList)) {
            subjectList = new ArrayList<>();
            subjectMapper.put(tag, subjectList);
        }
        Subject<T, T> subject = PublishSubject.create();
        subjectList.add(subject);
        LogUtil.d(TAG, tag + "  size:" + subjectList.size());
        return subject;
    }

    /**
     * 注销事件
     * @param tag
     */
    public void unregister(@NonNull Object tag) {
        List<Subject> subjects = subjectMapper.get(tag);
        if (CollectionUtils.isNotEmpty(subjects)) {
            subjectMapper.remove(tag);
        }
    }

    /**
     * 取消监听
     *
     * @param tag
     * @param observable
     * @return
     */
    public RxBus unregister(@NonNull Object tag,
                            @NonNull Observable<?> observable) {
        if (null == observable)
            return $();
        List<Subject> subjects = subjectMapper.get(tag);
        if (CollectionUtils.isNotEmpty(subjects)) {
            subjects.remove(observable);
            subjectMapper.remove(tag);
            LogUtil.d(TAG, tag + "  size:" + subjects.size());
        }
        return $();
    }

   /* public void post(@NonNull Object content) {
        post(content.getClass().getName(), content);
    }*/

    /**
     * 触发事件
     *
     * @param content
     */
    public void post(@NonNull Object tag, @NonNull Object content) {
        LogUtil.d(TAG, "post: eventName: " + tag);
        List<Subject> subjectList = subjectMapper.get(tag);
        if (CollectionUtils.isNotEmpty(subjectList)) {
            for (Subject subject : subjectList) {
                subject.onNext(content);
                LogUtil.d(TAG, "onEvent: eventName: " + tag);
            }
        }
    }

}
