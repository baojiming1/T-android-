/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.activity</p>
 * <p>File：TBaseViewPagerActivity.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/2/15:58.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.bob.t.R;
import com.bob.t.base.adapter.ViewPagerFragmentStatePagerAdapter;

/**<p>Class：com.bob.t.base.activity.TBaseViewPagerActivity</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/2/15:58
 * @version 1.0.0
 */

public abstract class TBaseViewPagerActivity extends TBaseActivity {

    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;

    protected ViewPagerFragmentStatePagerAdapter mViewPagerFragmentStatePagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewLayout();
        mTabLayout = findByViewId(R.id.mTabLayout);
        mViewPager = findByViewId(R.id.mViewPager);

        initView(mTabLayout, mViewPager);

        mViewPagerFragmentStatePagerAdapter = getViewPagerFragmentPagerAdapter(getSupportFragmentManager(), mTabLayout, mViewPager );
        onSetupTabAdapter(mViewPagerFragmentStatePagerAdapter);
        mViewPagerFragmentStatePagerAdapter.notifyDataSetChanged();
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPagerFragmentStatePagerAdapter.showTabTitle();          //显示图标和自定义View
    }

    /**
     * 自定义时可重写
     * @param mFragmentManager
     * @param mTabLayout
     * @param mViewPager
     * @return
     */
    protected ViewPagerFragmentStatePagerAdapter getViewPagerFragmentPagerAdapter(FragmentManager mFragmentManager, TabLayout mTabLayout, ViewPager mViewPager){
        ViewPagerFragmentStatePagerAdapter mViewPagerFragmentStatePagerAdapter = new ViewPagerFragmentStatePagerAdapter(mFragmentManager, mViewPager, mTabLayout);
        return mViewPagerFragmentStatePagerAdapter;
    }

    /**
     * 设置子Fragment
     * @param mViewPagerFragmentStatePagerAdapter
     */
    public abstract void onSetupTabAdapter(ViewPagerFragmentStatePagerAdapter mViewPagerFragmentStatePagerAdapter);


    /**
     * 设置布局文件，文件中必须包含R.id.mViewPager   、 R.id.mTabLayout
     */
    public abstract void setContentViewLayout();

    /**
     * 自定义其他参数初始化
     */
    public abstract void initView(TabLayout mTabLayout, ViewPager mViewPager );
}
