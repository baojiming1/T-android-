/**
 * <p>Project：AndroidT</p>
 * <p>Package：	com.bob.t.module</p>
 * <p>File：ContentResult.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/6/1/16:09.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.bean;

import android.nfc.Tag;

import java.util.List;

/**<p>Class：com.bob.t.module.bean.ContentResult</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/6/1/16:09
 * @version 1.0.0
 */

public class ContentResult {

    private int comment;            //评论数量
    private boolean delStatus;      //删除状态
    private int favorites;          //收藏数
    private String gpsX;            //
    private String gpsY;
    private String id;              //帖子主键
    private boolean isAttention;     //关注状态
    private boolean isFavorite;     //收藏状态
    private boolean isPraise;       //点赞状态
    private String mainImage;       //主图
    private String message;         //内容信息
    private int praise;             //点赞数
    private int type;               //类型            // 1:普通文章 2：推荐文章 3.活动文章
    private long updateTime;
    private String userId;          //用户ID
    private int views;              //游览的次数
    private String video;
    private String url;
    private Short status ;              // 帖子的审核状态  0:待审核  1:审核通过  2:审核不通过

    private List<ContentImage> images;      //帖子图片
    private List<User> praisePeople;    //点赞的用户
    private List<Tag> tags;         //标签
    private User user;              //帖子的作者
    private String productUrl;      //产品的详情页
    private String productId;       //产品ID

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public boolean isDelStatus() {
        return delStatus;
    }

    public void setDelStatus(boolean delStatus) {
        this.delStatus = delStatus;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getGpsX() {
        return gpsX;
    }

    public void setGpsX(String gpsX) {
        this.gpsX = gpsX;
    }

    public String getGpsY() {
        return gpsY;
    }

    public void setGpsY(String gpsY) {
        this.gpsY = gpsY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAttention() {
        return isAttention;
    }

    public void setAttention(boolean attention) {
        isAttention = attention;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isPraise() {
        return isPraise;
    }

    public void setPraise(boolean praise) {
        isPraise = praise;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
