/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.util</p>
 * <p>File：CollectionUtils.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/1/13/10:51.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.util;

import java.util.Collection;
import java.util.Map;

/**<p>Class：com.tp.venus.util.CollectionUtils</p>
 * <p>Description：</p>
 * <pre>
 *      集合工具类
 * </pre>
 * @author 鲍建明
 * @date 2016/1/13/10:51
 * @version 1.0.0
 */

public class CollectionUtils {

    public static boolean isEmpty(Collection<?> coll){
        return coll == null || coll.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> coll){
        return !isEmpty(coll);
    }

    public static boolean isMapEmpty(Map<?, ?> map){
        return map == null ||  map.size() == 0;
    }

    public static boolean isMapNotEmpty(Map<?, ?> map){
        return !isMapEmpty(map);
    }

    public static boolean isArrayEmpty(Object[] objs){
        return objs == null || objs.length == 0;
    }

    public static boolean isArrayNotEmpty(Object[] objs){
        return !isArrayEmpty(objs);
    }
}
