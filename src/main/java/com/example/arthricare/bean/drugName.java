package com.example.arthricare.bean;

public class drugName {

    private String id;

    private String medicationName;

    private String primaryUse;

    public drugName(String id, String medicationName, String primaryUse) {
        this.id = id;
        this.medicationName = medicationName;
        this.primaryUse = primaryUse;
    }

    public drugName(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getPrimaryUse() {
        return primaryUse;
    }

    public void setPrimaryUse(String primaryUse) {
        this.primaryUse = primaryUse;
    }

    @Override
    public String toString() {
        return "drugName{" +
                "id='" + id + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", primaryUse='" + primaryUse + '\'' +
                '}';
    }
}
