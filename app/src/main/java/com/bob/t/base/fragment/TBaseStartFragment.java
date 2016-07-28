/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.fragment</p>
 * <p>File：TBaseStartFragment.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/2/16:50.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bob.t.base.mvp.TBasePresenter;
import com.bob.t.base.mvp.TListPresenter;

/**<p>Class：com.bob.t.base.fragment.TBaseStartFragment</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/2/16:50
 * @version 1.0.0
 */

public abstract class TBaseStartFragment extends TBaseFragment {

    protected TBasePresenter mTBasePresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTBasePresenter = getPresenter();
        if( ! lazyLoad() ){
            mTBasePresenter.onStart();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTBasePresenter.onDestroy();
    }



    protected abstract <T> TListPresenter<T> getPresenter();


    /********************************* 可重写 ***************************/
    /**
     * 是否立马发送请求
     * @return
     */
    protected boolean lazyLoad(){
        return false;
    }

}
