package com.example.arthricare.bean.valueObject;

import java.sql.Date;

public class HomePageData {

    private long userId;

    private long reminderId;

    private java.util.Date takeMedTime;

    private Date chooseDate;

    public HomePageData() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(Date chooseDate) {
        this.chooseDate = chooseDate;
    }

    public long getReminderId() {
        return reminderId;
    }

    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }

    public java.util.Date getTakeMedTime() {
        return takeMedTime;
    }

    public void setTakeMedTime(java.util.Date takeMedTime) {
        this.takeMedTime = takeMedTime;
    }

    @Override
    public String toString() {
        return "HomePageData{" +
                "userId=" + userId +
                ", reminderId=" + reminderId +
                ", takeMedTime=" + takeMedTime +
                ", chooseDate=" + chooseDate +
                '}';
    }
}
