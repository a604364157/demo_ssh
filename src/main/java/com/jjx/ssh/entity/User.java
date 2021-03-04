package com.jjx.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author jiangjx
 */
@Entity
public class User {
    private long keyId;
    private String userName;
    private String nickName;
    private String password;
    private String avatarUrl;
    private String phone;
    private String qq;
    private String weChat;
    private Timestamp addTime;
    private String addUser;
    private Timestamp updateTime;
    private String updateUser;
    private String requestId;

    @Id
    @Column(name = "key_id")
    public long getKeyId() {
        return keyId;
    }

    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "we_chat")
    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Basic
    @Column(name = "add_time")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "add_user")
    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_user")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "request_id")
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return keyId == user.keyId && Objects.equals(userName, user.userName) && Objects.equals(nickName, user.nickName) && Objects.equals(password, user.password) && Objects.equals(avatarUrl, user.avatarUrl) && Objects.equals(phone, user.phone) && Objects.equals(qq, user.qq) && Objects.equals(weChat, user.weChat) && Objects.equals(addTime, user.addTime) && Objects.equals(addUser, user.addUser) && Objects.equals(updateTime, user.updateTime) && Objects.equals(updateUser, user.updateUser) && Objects.equals(requestId, user.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId, userName, nickName, password, avatarUrl, phone, qq, weChat, addTime, addUser, updateTime, updateUser, requestId);
    }
}
