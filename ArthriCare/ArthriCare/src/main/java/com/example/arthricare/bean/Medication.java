package com.example.arthricare.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Medication {

    private Integer id;
    private Integer userId;
    private String medicationType;
    private String medicationName;
    private String medicationCategory;
    private String frequency;
    private double dosageUnit;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String note;
    public Medication() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
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

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", userId=" + userId +
                ", medicationType='" + medicationType + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", medicationCategory='" + medicationCategory + '\'' +
                ", frequency='" + frequency + '\'' +
                ", dosageUnit=" + dosageUnit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

