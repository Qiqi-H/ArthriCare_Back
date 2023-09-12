package com.example.arthricare.bean;

import java.util.Date;

public class ComityPostReply {

    private int replyId;
    private int postId;

    private int userId;

    private String content;

    private Date createdTime;

    public ComityPostReply() {
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ComityPostReply{" +
                "replyId=" + replyId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
