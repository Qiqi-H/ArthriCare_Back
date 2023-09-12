package com.example.arthricare.bean;

import java.util.Date;

public class ComityChatChannel {

    private int channelId;

    private String userFromId;

    private  String userToId;

    private Date lastUpdateTime;

    private String newContent;

    public ComityChatChannel() {
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
    public String getUserFromId() {
        return userFromId;
    }

    public void setUserFromId(String userFromId) {
        this.userFromId = userFromId;
    }

    public String getUserToId() {
        return userToId;
    }

    public void setUserToId(String userToId) {
        this.userToId = userToId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    @Override
    public String toString() {
        return "ComityChatChannel{" +
                "channelId=" + channelId +
                ", userFromId='" + userFromId + '\'' +
                ", userToId='" + userToId + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", newContent='" + newContent + '\'' +
                '}';
    }
}
