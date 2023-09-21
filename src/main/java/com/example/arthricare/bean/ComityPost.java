package com.example.arthricare.bean;

import java.util.Date;

public class ComityPost {

    int postId;

    int userId;

    String userName;

    String title;

    String content;

    Date createdTime;

    String forumSection;

    boolean haveImage;

    int likeNum;

    int commentNum;

    public ComityPost() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getForumSection() {
        return forumSection;
    }

    public void setForumSection(String forumSection) {
        this.forumSection = forumSection;
    }

    public boolean isHaveImage() {
        return haveImage;
    }

    public void setHaveImage(boolean haveImage) {
        this.haveImage = haveImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "ComityPost{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", forumSection='" + forumSection + '\'' +
                ", haveImage=" + haveImage +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                '}';
    }
}
