/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.adapter</p>
 * <p>File：TBaseAdapter.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/27/9:30.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**<p>Class：com.bob.t.base.adapter.TBaseAdapter</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/27/9:30
 * @version 1.0.0
 */

public abstract class TBaseAdapter<T> extends BaseQuickAdapter<T> {


    public TBaseAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    public TBaseAdapter(Context context, int layoutResId) {
        super(context, layoutResId, new ArrayList<T>());
    }

    public TBaseAdapter(Context context, List<T> data) {
        super(context, data);
    }

    public TBaseAdapter(Context context, View contentView, List<T> data) {
        super(context, contentView, data);
    }

    public TBaseAdapter(Context context) {
        super(context);
    }

}
