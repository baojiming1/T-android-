/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：ContentResultAdapter.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/1/16:11.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.bob.t.base.adapter.TBaseAdapter;
import com.bob.t.module.TableActivity;
import com.bob.t.module.bean.ContentResult;
import com.chad.library.adapter.base.BaseViewHolder;

/**<p>Class：com.bob.t.module.adapter.ContentResultAdapter</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/1/16:11
 * @version 1.0.0
 */

public class ContentResultAdapter extends TBaseAdapter<ContentResult> {

    public ContentResultAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ContentResult contentResult) {
        baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, TableActivity.class);
                mContext.startActivity(i);
            }
        });
    }
}
