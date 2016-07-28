/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：MainActivity.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/15:29.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bob.t.R;
import com.bob.t.base.activity.TBaseActivity;

/**<p>Class：com.bob.t.module.MainActivity</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/15:29
 * @version 1.0.0
 */

public class MainActivity extends TBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);
        replaceFramentLayout(R.id.mFrameLayout, MainFragment.newInstance());
    }

}
