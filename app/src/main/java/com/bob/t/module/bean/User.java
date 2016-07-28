/**
 * <p>Project：venus</p>
 * <p>Package：	com.tp.venus.module.user.bean</p>
 * <p>File：User.java</p>
 * <p>Version： 4.0.0</p>
 * <p>Date： 2016/1/11/19:21.</p>
 * Copyright © 2016 www.qbt365.com Corporation Inc. All rights reserved.
 */
package com.bob.t.module.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.bob.t.util.StringUtil;


/**<p>Class：com.tp.venus.module.user.bean.User</p>
 * <p>Description：</p>
 * <pre>
 *
 * </pre>
 * @author 鲍建明
 * @date 2016/1/11/19:21
 * @version 1.0.0
 */

public class User implements Parcelable {

    private String id;          //主键
    private String userId;      //主键  和ID一致,但是有时候返回的是userId
    private String number;      //求号
    private String mobile;       //手机号
    private String email;       //邮箱
    private Integer age;        //年龄
    private String nickname;       //昵称
    private String signature;       //个性签名
    private Short gender;           //性别
    private String icon;        //头像
    private Long birthday;      //生日
    private Short type;         //用户类型
    private Long createTime;
    private Long updateTime;
    private Short souce;        //来源
    private Short status;       //状态        0 : 用户禁用   1 ： 正常   2 ：惩罚中
    private String token;       //
    private String address;     //地址
    private Boolean authentication;     //是否认证
    private Long expired;           //token过期时间
    private Integer useIntegral ;           //可用积分useIntegral
    private Long countIntegral ;            //历史积分
    private Integer contentCount;           //发帖总数
    private Integer fnsCount ;              //粉丝总数
    private Integer level ;                 //等级
    private Integer commentCount ;          //评论总数
    private Boolean isAttention;            //是否被关注
    private Integer praise;                 //被赞数   同praiseCount一样，有些地方使用的是此
    private Integer praiseCount  ;              //被赞数

    public String getId() {
        if(StringUtil.isNotEmpty(userId)){
            return userId;
        }
        if( StringUtil.isNotEmpty(id)){
            return id;
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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

    public Short getSouce() {
        return souce;
    }

    public void setSouce(Short souce) {
        this.souce = souce;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Boolean authentication) {
        this.authentication = authentication;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }


    public Integer getUseIntegral() {
        return useIntegral;
    }

    public void setUseIntegral(Integer useIntegral) {
        this.useIntegral = useIntegral;
    }

    public Long getCountIntegral() {
        return countIntegral;
    }

    public void setCountIntegral(Long countIntegral) {
        this.countIntegral = countIntegral;
    }

    public Integer getContentCount() {
        return contentCount;
    }

    public void setContentCount(Integer contentCount) {
        this.contentCount = contentCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getFnsCount() {
        return fnsCount;
    }

    public void setFnsCount(Integer fnsCount) {
        this.fnsCount = fnsCount;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getUserId() {
        if(StringUtil.isNotEmpty(userId)){
            return userId;
        }
        if( StringUtil.isNotEmpty(id)){
            return id;
        }
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public Boolean isIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Boolean attention) {
        isAttention = attention;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public User() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.userId);
        dest.writeString(this.number);
        dest.writeString(this.mobile);
        dest.writeString(this.email);
        dest.writeValue(this.age);
        dest.writeString(this.nickname);
        dest.writeString(this.signature);
        dest.writeValue(this.gender);
        dest.writeString(this.icon);
        dest.writeValue(this.birthday);
        dest.writeValue(this.type);
        dest.writeValue(this.createTime);
        dest.writeValue(this.updateTime);
        dest.writeValue(this.souce);
        dest.writeValue(this.status);
        dest.writeString(this.token);
        dest.writeString(this.address);
        dest.writeValue(this.authentication);
        dest.writeValue(this.expired);
        dest.writeValue(this.useIntegral);
        dest.writeValue(this.countIntegral);
        dest.writeValue(this.contentCount);
        dest.writeValue(this.fnsCount);
        dest.writeValue(this.level);
        dest.writeValue(this.commentCount);
        dest.writeValue(this.isAttention);
        dest.writeValue(this.praise);
        dest.writeValue(this.praiseCount);
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.userId = in.readString();
        this.number = in.readString();
        this.mobile = in.readString();
        this.email = in.readString();
        this.age = (Integer) in.readValue(Integer.class.getClassLoader());
        this.nickname = in.readString();
        this.signature = in.readString();
        this.gender = in.readParcelable(Short.class.getClassLoader());
        this.icon = in.readString();
        this.birthday = (Long) in.readValue(Long.class.getClassLoader());
        this.type = in.readParcelable(Short.class.getClassLoader());
        this.createTime = (Long) in.readValue(Long.class.getClassLoader());
        this.updateTime = (Long) in.readValue(Long.class.getClassLoader());
        this.souce = in.readParcelable(Short.class.getClassLoader());
        this.status = in.readParcelable(Short.class.getClassLoader());
        this.token = in.readString();
        this.address = in.readString();
        this.authentication = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.expired = (Long) in.readValue(Long.class.getClassLoader());
        this.useIntegral = (Integer) in.readValue(Integer.class.getClassLoader());
        this.countIntegral = (Long) in.readValue(Long.class.getClassLoader());
        this.contentCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.fnsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.level = (Integer) in.readValue(Integer.class.getClassLoader());
        this.commentCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isAttention = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.praise = (Integer) in.readValue(Integer.class.getClassLoader());
        this.praiseCount = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //自定义equals方法
        User user = (User) o;
        if ( StringUtil.isNotEmpty(id) ){
            if( id.equals(user.getId()) ){
                return true;
            } else if( id.equals(user.getUserId()) ){
                return true;
            } else {
                return false;
            }
        } else if( StringUtil.isNotEmpty( userId )){
            if( userId.equals(user.getId()) ){
                return true;
            } else if( userId.equals(user.getUserId()) ){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
