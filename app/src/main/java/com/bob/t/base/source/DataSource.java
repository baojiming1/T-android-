/**
 * <p>Project：T</p>
 * <p>Package：	com.bob.t.base.source</p>
 * <p>File：DataSource.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/7/27/17:32.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.base.source;

import rx.Observable;

/**<p>Class：com.bob.t.base.source.DataSource</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/7/27/17:32
 * @version 1.0.0
 */

public interface DataSource<T> {

    Observable<T>  getData();

}
