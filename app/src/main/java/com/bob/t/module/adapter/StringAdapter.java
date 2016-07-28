/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：StringAdapter.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/15:39.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.adapter;

import android.content.Context;

import com.bob.t.R;
import com.bob.t.base.adapter.TBaseAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**<p>Class：com.bob.t.module.adapter.StringAdapter</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/15:39
 * @version 1.0.0
 */

public class StringAdapter extends TBaseAdapter<String> {

    public StringAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.mTextView, s).linkify(R.id.mTextView);
    }
}
