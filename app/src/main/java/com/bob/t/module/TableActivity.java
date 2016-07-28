/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：TableActivity.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/2/16:12.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.bob.t.R;
import com.bob.t.base.activity.TBaseViewPagerActivity;
import com.bob.t.base.adapter.ViewPagerFragmentStatePagerAdapter;

/**<p>Class：com.bob.t.module.TableActivity</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/2/16:12
 * @version 1.0.0
 */

public class TableActivity extends TBaseViewPagerActivity {


    @Override
    public void onSetupTabAdapter(ViewPagerFragmentStatePagerAdapter mViewPagerFragmentStatePagerAdapter) {
        mViewPagerFragmentStatePagerAdapter.addTab("第一", MainFragment.newInstance());
        mViewPagerFragmentStatePagerAdapter.addTab("第二", MainFragment.newInstance());
        mViewPagerFragmentStatePagerAdapter.addTab("第三", MainFragment.newInstance());
    }

    @Override
    public void setContentViewLayout() {
        setContentView(R.layout.test_viewpage_table);
    }

    @Override
    public void initView(TabLayout mTabLayout, ViewPager mViewPager) {

    }
}
