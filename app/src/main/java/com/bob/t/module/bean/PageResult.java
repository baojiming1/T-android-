/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.model</p>
 * <p>File：PageResult.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2015/10/8/10:29.</p>
 * Copyright © 2015 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.bean;

import java.io.Serializable;
import java.util.List;

/**<p>Class：com.tp.venus.model.PageResult</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2015/10/8/10:29
 * @version 1.0.0
 */

public class PageResult<T> implements Serializable{


    /**
     * total : 3
     * pageCount : 1
     * hasNext : false
     * pageSize : 20
     * rows : [{"id":644793689784188928,"icon":"www.baidu.com","nickname":"jack"},{"id":644847264749060096,"icon":"www.baidu.com","nickname":"成功"},{"id":647648129411186688,"icon":"www.bai.com","nickname":"测试账号"}]
     * pageNum : 1
     */
    private long total;
    private int pageCount;
    private boolean hasNext;
    private int pageSize;
    private List<T> rows;
    private int pageNum;

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public int getPageNum() {
        return pageNum;
    }

}
