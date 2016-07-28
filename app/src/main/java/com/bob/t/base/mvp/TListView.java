/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.mvp</p>
 * <p>File：TListView.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/17:18.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.mvp;

import java.util.List;

/**<p>Class：com.bob.t.base.mvp.TListView</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/17:18
 * @version 1.0.0
 */

public interface TListView<T> extends TBaseView {

    /**
     * 始终会执行的方法
     */
    void onCompleted();


    /**
     * 请求错误时
     */
    void onError();


    /**
     * 添加数据
     * @param data
     */
    void addData(List<T> data);

}
