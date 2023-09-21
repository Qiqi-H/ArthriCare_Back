package com.example.arthricare.bean.valueObject;

import java.sql.Time;
import java.time.LocalDateTime;

public class HomePageMedData {

    private long reminderId;
    private String medicationName;

    private Time reminderTime;

    private double dosageUnit;

    private String category;

    private boolean alreadyTakeMedication;
    private LocalDateTime takeMedTime;

    private String note;


    public HomePageMedData() {
    }

    public long getReminderId() {
        return reminderId;
    }

    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Time getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Time reminderTime) {
        this.reminderTime = reminderTime;
    }

    public double getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(double dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public LocalDateTime getTakeMedTime() {
        return takeMedTime;
    }

    public void setTakeMedTime(LocalDateTime takeMedTime) {
        this.takeMedTime = takeMedTime;
    }

    public boolean isAlreadyTakeMedication() {
        return alreadyTakeMedication;
    }

    public void setAlreadyTakeMedication(boolean alreadyTakeMedication) {
        this.alreadyTakeMedication = alreadyTakeMedication;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "HomePageMedData{" +
                "reminderId=" + reminderId +
                ", medicationName='" + medicationName + '\'' +
                ", reminderTime=" + reminderTime +
                ", dosageUnit=" + dosageUnit +
                ", category='" + category + '\'' +
                ", alreadyTakeMedication=" + alreadyTakeMedication +
                ", takeMedTime=" + takeMedTime +
                ", note='" + note + '\'' +
                '}';
    }
}
