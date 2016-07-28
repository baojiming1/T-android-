/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.rx</p>
 * <p>File：ProgressSubscriber.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/1/14:38.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.rx;

/**<p>Class：com.bob.t.base.rx.ProgressSubscriber</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/1/14:38
 * @version 1.0.0
 */

public abstract class ProgressSubscriber<T> extends RxSubscriber<T> implements ProgressDialogHandler.ProgressCancelListener {

    private ProgressDialogHandler mProgressDialogHandler;

    public ProgressSubscriber(){
        mProgressDialogHandler = newDialog();
        mProgressDialogHandler.addProgressCancelListener(this);
    }

    @Override
    public void onStart() {
        mProgressDialogHandler.showDialog();
        super.onStart();
    }

    @Override
    public void onCompleted() {
        mProgressDialogHandler.dismissDialog();
        super.onCompleted();
    }


    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    protected abstract ProgressDialogHandler newDialog();
}
