/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：MainFragment.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/15:37.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.bob.t.R;
import com.bob.t.base.adapter.TBaseAdapter;
import com.bob.t.base.builder.RequestBodyBuilder;
import com.bob.t.base.fragment.TBaseSwipRefreshFragment;
import com.bob.t.base.mvp.TListPresenter;
import com.bob.t.config.TConfig;
import com.bob.t.module.adapter.ContentResultAdapter;
import com.bob.t.module.bean.ContentResult;
import com.bob.t.module.bean.PageResult;
import com.bob.t.module.p.BlPresenter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import okhttp3.Request;

/**<p>Class：com.bob.t.module.MainFragment</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/15:37
 * @version 1.0.0
 */

public class MainFragment extends TBaseSwipRefreshFragment<ContentResult> {


    public static MainFragment newInstance(){
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.t_base_recyclerview, container, false);
    }

    @Override
    public Request buildRequest(Request.Builder builder, RequestBodyBuilder mRequestBodyBuilder) {
        return builder.url(TConfig.getSetting().host + "/content/search/found").post(mRequestBodyBuilder.build()).build();
    }

    @Override
    public Type getReturnClass() {
        return new TypeToken<PageResult<ContentResult>>(){}.getType();
    }


    @Override
    protected void initRefreshLayout(View view) {
        super.initRefreshLayout(view);
    }

    @Override
    protected TListPresenter<ContentResult> getPresenter() {
        return new BlPresenter<>(this);
    }

    @Override
    protected TBaseAdapter<ContentResult> getAdapter() {
        return new ContentResultAdapter(getContext(), R.layout.test_string_list_item);
    }

    @Override
    protected View getEmptyView(LayoutInflater inflater, ViewParent parent) {
        TextView tv = new TextView(getContext());
        tv.setText("data is null");
        return tv;
    }

    @Override
    protected View getEmptyNextLoadView(LayoutInflater inflater, ViewParent parent) {
        TextView tv = new TextView(getContext());
        tv.setText("没有更多数据了");
        return tv;
    }
}
