/**
 * <p>Project：T</p>
 * <p>Package：	com.bob.t.base.source</p>
 * <p>File：MemorySource.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/7/27/18:05.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.source;

import rx.Observable;

/**<p>Class：com.bob.t.base.source.MemorySource</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/7/27/18:05
 * @version 1.0.0
 */

public class MemorySource<T> implements DataSource<T> {
    @Override
    public Observable<T> getData() {
        return null;
    }
}
