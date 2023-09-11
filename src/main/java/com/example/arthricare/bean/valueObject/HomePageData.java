package com.example.arthricare.bean.valueObject;

import java.sql.Date;

public class HomePageData {

    private int userId;

    private int reminderId;

    private java.util.Date takeMedTime;

    private Date chooseDate;

    public HomePageData() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(Date chooseDate) {
        this.chooseDate = chooseDate;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
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
