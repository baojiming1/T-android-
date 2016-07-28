/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.base.mvp</p>
 * <p>File：TListModel.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/5/31/17:41.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.mvp;

import com.bob.t.base.source.DataSource;
import com.bob.t.base.source.DiskSource;
import com.bob.t.base.source.MemorySource;
import com.bob.t.base.source.NetworkSource;

import java.lang.reflect.Type;

import okhttp3.Request;
import rx.Observable;

/**<p>Class：com.bob.t.base.mvp.TListModel</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/5/31/17:41
 * @version 1.0.0
 */

public class TListModel<T> extends TBaseModel {

    public Observable<T> sendList(final Request request, final Type mainType, final Type subType){
        //TODO 没有思路以后写
        DataSource<T> network = new NetworkSource<>(request, mainType, subType);
        DataSource<T> disk = new DiskSource<>();
        DataSource<T> memory = new MemorySource<>();
        return  Observable.concat( memory.getData(), disk.getData(), network.getData() ).first();
    }




}
