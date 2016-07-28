/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.rx</p>
 * <p>File：ProgressDialogHandler.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/1/14:50.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.rx;

/**<p>Class：com.bob.t.base.rx.ProgressDialogHandler</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/1/14:50
 * @version 1.0.0
 */

public interface ProgressDialogHandler {

    /**
     * 销毁对话框
     */
    void dismissDialog();

    /**
     * 显示对话框
     */
    void showDialog();

    /**
     * 设置取消后的监听事件
     * @param mProgressCancelListener
     */
    void addProgressCancelListener(ProgressCancelListener mProgressCancelListener);


    public interface ProgressCancelListener{
        /**
         * 对话框取消后的事件
         */
        void onCancelProgress();
    }
}
