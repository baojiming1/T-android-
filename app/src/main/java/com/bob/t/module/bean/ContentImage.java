/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.module.content.bean</p>
 * <p>File：ContentImage.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/1/11/19:19.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.bean;

import java.util.List;

/**<p>Class：com.tp.venus.module.content.bean.ContentImage</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/1/11/19:19
 * @version 1.0.0
 */

public class ContentImage  {

    /**
     * id : 683910943133925376
     * imageTags : []
     * isMain : true
     * url : http://7xnwo1.media1.z0.glb.clouddn.com/FvWa5woiSH2dw-ZZb00J423X0tbt
     */

    private String id;
    private boolean isMain;
    private String url;
    private List<?> imageTags;

    public void setId(String id) {
        this.id = id;
    }

    public void setIsMain(boolean isMain) {
        this.isMain = isMain;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageTags(List<?> imageTags) {
        this.imageTags = imageTags;
    }

    public String getId() {
        return id;
    }

    public boolean isIsMain() {
        return isMain;
    }

    public String getImageUrl() {
        return url;
    }

    public List<?> getImageTags() {
        return imageTags;
    }
}
