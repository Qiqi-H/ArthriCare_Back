package com.example.arthricare.service;

import com.example.arthricare.bean.Medication;
import com.example.arthricare.mapper.MedicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    private final MedicationMapper medicationMapper;

    @Autowired
    public MedicationService(MedicationMapper medicationMapper) {
        this.medicationMapper = medicationMapper;
    }

    public void createMedication(Medication medication) {
        medicationMapper.insertMedication(medication);
    }

    public void updateMedication(Medication medication) {
        medicationMapper.updateMedication(medication);
    }

    public void deleteMedication(Integer id) {
        medicationMapper.deleteMedication(id);
    }

    public Medication getMedicationById(Integer id) {
        return medicationMapper.findById(id);
    }


    public List<Medication> getAllMedications() {
        return medicationMapper.findAll();
    }

    public List<Medication> findMedicationByUserId(Integer id)
    {
        return  medicationMapper.findMedicationByUserId(id);
    }
}


