/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.module.content.bean</p>
 * <p>File：Tag.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/1/11/19:33.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.bean;

/**<p>Class：com.tp.venus.module.content.bean.Tag</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/1/11/19:33
 * @version 1.0.0
 */

public class Tag {

    private String id;      //主键
    private String name;    //标签名称
    private Short type;     //标签类型
    private String description;     //标签描述
    private String backgroud;       //标签背景图
    private String userId;          //占领者主键
    private Long createTime;
    private Long updateTime;
    private Boolean hot;            //是否最热
    private Integer views ;         //查看数
    private Integer praise ;        //点赞数
    private Integer attentions ;    //关注数
    private Integer favorites ;     //收藏次数
    private Integer useNumber ;     //使用次数
    private Integer contentCount ;      //帖子的使用数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroud() {
        return backgroud;
    }

    public void setBackgroud(String backgroud) {
        this.backgroud = backgroud;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getAttentions() {
        return attentions;
    }

    public void setAttentions(Integer attentions) {
        this.attentions = attentions;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public Integer getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(Integer useNumber) {
        this.useNumber = useNumber;
    }

    public Integer getContentCount() {
        return contentCount;
    }

    public void setContentCount(Integer contentCount) {
        this.contentCount = contentCount;
    }
}
