/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.fragment</p>
 * <p>File：TBaseSwipRefreshFragment.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/13:37.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.bob.t.R;


/**<p>Class：com.bob.t.base.fragment.TBaseSwipRefreshFragment</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/13:37
 * @version 1.0.0
 */

public abstract  class TBaseSwipRefreshFragment<T> extends TBaseMoreFragment<T> implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initRefreshLayout(view);
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 默认SwipeRefreshLayout 刷新组件
     * @param view
     */
    protected void initRefreshLayout(View view){
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.mSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        setSwipeRefreshLoadingState();
        pageNow = 1;
        sendHttp();
    }

    @Override
    public void onCompleted() {
        super.onCompleted();
        setSwipeRefreshLoadedState();
    }

    @Override
    public void onError() {
        super.onError();
        setSwipeRefreshLoadedState();
    }

    /**
     * 设置顶部正在加载的状态
     */
    protected void setSwipeRefreshLoadingState() {
        if (mSwipeRefreshLayout != null) {
            if( !mSwipeRefreshLayout.isRefreshing() ){
                mSwipeRefreshLayout.setRefreshing(true);
                // 防止多次重复刷新
                mSwipeRefreshLayout.setEnabled(false);
            }
        }
    }

    /**
     * 设置顶部加载完毕的状态
     */
    protected void setSwipeRefreshLoadedState() {
        if (mSwipeRefreshLayout != null) {
            if( mSwipeRefreshLayout.isRefreshing() ){
                mSwipeRefreshLayout.setRefreshing(false);
                mSwipeRefreshLayout.setEnabled(true);
            }
        }
    }

}
