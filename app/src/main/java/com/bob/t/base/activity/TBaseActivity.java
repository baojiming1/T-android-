/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base</p>
 * <p>File：TBaseActivity.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/24/10:53.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bob.t.util.AppManager;

/**<p>Class：com.bob.t.base.activity.TBaseActivity</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/24/10:53
 * @version 1.0.0
 */

public abstract class TBaseActivity extends AppCompatActivity  {

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);

    }

    /**
     * findViewById
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findByViewId(int id) {
        return (T)findViewById(id);
    }

    @Override
    public void onBackPressed() {
        AppManager.getInstance().finishActivity();
        super.onBackPressed();
    }


    /**
     * 替换FragmentLayout
     * @param framentId
     * @param fragment
     */
    public void replaceFramentLayout(@IdRes int framentId, @Nullable  Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(framentId, fragment).commit();
    }

}
