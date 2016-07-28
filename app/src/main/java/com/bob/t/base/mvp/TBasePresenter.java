/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.mvp</p>
 * <p>File：TBasePresenter.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/10:32.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.mvp;

import android.support.annotation.NonNull;

import com.bob.t.base.rx.RxBusManager;

/**<p>Class：com.bob.t.base.mvp.TBasePresenter</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/10:32
 * @version 1.0.0
 */

public abstract class TBasePresenter<V extends TBaseView> {

    protected V mBaseView;
    protected RxBusManager manager;


    public TBasePresenter(@NonNull V view){
        this.mBaseView = view;
        this.manager = new RxBusManager();
    }

    public abstract void onStart();

    public void onDestroy(){
        manager.clear();
        manager = null;
    }

}
