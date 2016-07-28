/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.fragment</p>
 * <p>File：TBaseMoreFragment.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/2/16:25.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

import com.bob.t.R;
import com.bob.t.base.adapter.TBaseAdapter;
import com.bob.t.base.bean.JsonMessage;
import com.bob.t.base.listener.OnHttpSendBeforeListener;
import com.bob.t.base.mvp.TListPresenter;
import com.bob.t.base.mvp.TListView;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.lang.reflect.Type;
import java.util.List;

/**<p>Class：com.bob.t.base.fragment.TBaseMoreFragment</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/2/16:25
 * @version 1.0.0
 */

public abstract class TBaseMoreFragment<T> extends TBaseStartFragment implements TListView<T>, OnHttpSendBeforeListener, BaseQuickAdapter.RequestLoadMoreListener  {

    protected RecyclerView mRecyclerView;
    protected TListPresenter<T> presenter;

    protected TBaseAdapter<T> adapter;
    protected int pageNow = 1;
    protected int pageSize = 20;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(getLayoutManager());
        adapter = getAdapter();
        adapter.setOnLoadMoreListener(this);
        adapter.openLoadMore(pageSize, true);
        //adapter.openLoadAnimation();
        buildAdapter(adapter);
        mRecyclerView.setAdapter(adapter);
        presenter = getPresenter();
        if( !lazyLoad() ){
            sendHttp();
        }
    }

    @Override
    public void onLoadMoreRequested() {
        pageNow++;
        sendHttp();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError() {
        adapter.notifyDataChangedAfterLoadMore(true);

    }

    /**
     * 数据添加
     * @param data
     */
    @Override
    public void addData(List<T> data) {
        boolean isNextLoad = data.size() == pageSize;                   //根据pagesize来判断是否还有下一页，这样最后一页会多发请求
        if( pageNow == 1){                  // 第一页的时候
            adapter.setNewData(data);
            if( data.size() == 0){                  //空数据
                adapter.setEmptyView(getEmptyView(LayoutInflater.from(getContext()), mRecyclerView.getParent()));
                return ;
            }
            adapter.openLoadMore(pageSize, true);
        } else {
            if( !isNextLoad ){                              //没有下一页的处理方式
                adapter.addFooterView(getEmptyNextLoadView(LayoutInflater.from(getContext()), mRecyclerView.getParent()));
            }
            if(data.size() != 0){
                adapter.notifyDataChangedAfterLoadMore(data, isNextLoad);
            }
        }
    }


    /******************************************************** 需要时重写 **********************************************************/

    /**
     * 自定义Presenter 可重写
     * @return
     */
    @Override
    protected <T> TListPresenter<T> getPresenter() {
        return  new TListPresenter(this);
    }

    /**
     * 发送请求，默认只发 出一个请求
     */
    protected void sendHttp(){
        presenter.sendList(this, pageNow, pageSize);
    }


    /**
     * 可选择其他布局管理器Layoutmanager
     * @return
     */
    protected RecyclerView.LayoutManager getLayoutManager(){
        return new LinearLayoutManager(getContext());
    }

    /**
     * 其他adapter选项的定义
     * @param adapter
     */
    protected void buildAdapter(BaseQuickAdapter<T> adapter){}


    /**
     * 自定义类型时请重写该方法
     * @return
     */
    @Override
    public Type getMainReturnType() {
        return JsonMessage.class;
    }

    /*************************************************** 自定义空数据View **************************************************/

    /**
     * 自定义空数据的背景布局
     * @param parent
     * @return
     */
    protected View getEmptyView(LayoutInflater inflater, ViewParent parent){
        TextView tv = new TextView(getContext());
        tv.setText("data is null");
        return tv;
    }


    /**
     * 自定义没有更多数据的布局
     * @param parent
     * @return
     */
    protected View getEmptyNextLoadView(LayoutInflater inflater, ViewParent parent){
        TextView tv = new TextView(getContext());
        tv.setText("没有更多数据了");
        return tv;
    }


    /************************************************* 必须重写 ******************************************/
    /**
     * Adapter
     * @return
     */
    protected abstract TBaseAdapter<T> getAdapter();

}
