package com.example.arthricare.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Date;

public class Medication {

    private long medicationId;
    private long userId;
    private String medicationType;
    private String medicationName;
    private String medicationCategory;
    private String frequency;
    private double dosageUnit;

    private Date startDate;

    private Date endDate;

    private String note;

    private String reminderTimes;

    private boolean medicationExpiration;
    public Medication() {
    }

    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Integer id) {
        this.medicationId = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(String medicationType) {
        this.medicationType = medicationType;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationCategory() {
        return medicationCategory;
    }

    public void setMedicationCategory(String medicationCategory) {
        this.medicationCategory = medicationCategory;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Double getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(Double dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReminderTimes() {
        return reminderTimes;
    }

    public void setReminderTimes(String reminderTimes) {
        this.reminderTimes = reminderTimes;
    }

    public boolean isMedicationExpiration() {
        return medicationExpiration;
    }

    public void setMedicationExpiration(boolean medicationExpiration) {
        this.medicationExpiration = medicationExpiration;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationId=" + medicationId +
                ", userId=" + userId +
                ", medicationType='" + medicationType + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", medicationCategory='" + medicationCategory + '\'' +
                ", frequency='" + frequency + '\'' +
                ", dosageUnit=" + dosageUnit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", note='" + note + '\'' +
                ", reminderTimes='" + reminderTimes + '\'' +
                ", medicationExpiration=" + medicationExpiration +
                '}';
    }
}

