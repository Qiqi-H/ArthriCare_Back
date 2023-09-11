package com.example.arthricare.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Reminder {
    private int reminderId;
    private int medicationId;
    private Time reminderTime;
    private Date date;
    private boolean alreadyTakeMedication;
    private LocalDateTime takeMedTime;

    private java.util.Date reminderDateTime;

    public Reminder() {
    }


    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public Time getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Time reminderTime) {
        this.reminderTime = reminderTime;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAlreadyTakeMedication() {
        return alreadyTakeMedication;
    }

    public void setAlreadyTakeMedication(boolean alreadyTakeMedication) {
        this.alreadyTakeMedication = alreadyTakeMedication;
    }

    public LocalDateTime getTakeMedTime() {
        return takeMedTime;
    }

    public void setTakeMedTime(LocalDateTime takeMedTime) {
        this.takeMedTime = takeMedTime;
    }

    public java.util.Date getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(java.util.Date reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "reminderId=" + reminderId +
                ", medicationId=" + medicationId +
                ", reminderTime=" + reminderTime +
                ", date=" + date +
                ", alreadyTakeMedication=" + alreadyTakeMedication +
                ", takeMedTime=" + takeMedTime +
                ", reminderDateTime=" + reminderDateTime +
                '}';
    }
}

