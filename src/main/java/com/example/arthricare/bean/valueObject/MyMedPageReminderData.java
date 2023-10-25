package com.example.arthricare.bean.valueObject;

import java.util.Date;

public class MyMedPageReminderData {

    private Date reminderDate;
    private String reminderMessage;

    public MyMedPageReminderData() {
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getReminderMessage() {
        return reminderMessage;
    }

    public void setReminderMessage(String reminderMessage) {
        this.reminderMessage = reminderMessage;
    }

    @Override
    public String toString() {
        return "MyMedPageReminderData{" +
                "reminderDate=" + reminderDate +
                ", reminderMessage='" + reminderMessage + '\'' +
                '}';
    }
}
