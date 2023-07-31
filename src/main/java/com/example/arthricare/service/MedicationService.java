package com.example.arthricare.service;

import com.example.arthricare.bean.Medication;
import com.example.arthricare.bean.Reminder;
import com.example.arthricare.bean.valueObject.HomePageData;
import com.example.arthricare.bean.valueObject.HomePageMedData;
import com.example.arthricare.mapper.MedicationMapper;
import com.example.arthricare.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationService {
    private final MedicationMapper medicationMapper;
    private final UserMapper userMapper;

    private final ReminderService reminderService;

    @Autowired
    public MedicationService(MedicationMapper medicationMapper,UserMapper userMapper,ReminderService reminderService) {
        this.medicationMapper = medicationMapper;
        this.userMapper = userMapper;
        this.reminderService = reminderService;
    }

    public void createMedication(Medication medication) {
        medicationMapper.insertMedication(medication);
        long medicationId = medication.getMedicationId();
        reminderService.createReminders(medication.getReminderTimes(),medicationId,medication.getStartDate(),medication.getEndDate());
        userMapper.addPointsToUser(150,medication.getUserId());
    }

    public void updateMedication(Medication medication) {
        medicationMapper.updateMedication(medication);
        reminderService.updateReminder(medication.getReminderTimes(),medication.getMedicationId(),medication.getStartDate(),medication.getEndDate());
    }

    public void deleteMedication(Integer id) {
        medicationMapper.deleteMedication(id);
    }

    public Medication getMedicationById(long id) {
        return medicationMapper.findById(id);
    }


    public List<Medication> getAllMedications() {
        return medicationMapper.findAll();
    }

    public List<Medication> findMedicationByUserId(Integer id)
    {
        return  medicationMapper.findMedicationByUserId(id);
    }

    public List<HomePageMedData> findMedicationByUserIdAndDate(HomePageData homePageData)
    {
        long userId = homePageData.getUserId();
        Date chooseDate = homePageData.getChooseDate();
        List<Long> reminderIdList = medicationMapper.findReminderIdsByUserIdAndDate(userId,chooseDate);
        List<HomePageMedData> homePageMedDataList = new ArrayList<>();

        for (long rId : reminderIdList)
        {
            Reminder r = reminderService.findReminderByReminderId(rId);
            Medication m = getMedicationById(r.getMedicationId());
            HomePageMedData data = new HomePageMedData();
            data.setMedicationName(m.getMedicationName());
            data.setReminderTime(r.getReminderTime());
            data.setDosageUnit(m.getDosageUnit());
            data.setTakeMedTime(r.getTakeMedTime());
            data.setAlreadyTakeMedication(r.isAlreadyTakeMedication());
            data.setReminderId(rId);
            data.setCategory(m.getMedicationCategory());
            homePageMedDataList.add(data);
        }
        return homePageMedDataList;
    }

    public void updateMedicationExpirationStatues(long medicationId,boolean state)
    {
        medicationMapper.updateMedicationExpiration(medicationId,state);
    }

    public boolean checkMedicationExpiration(long medicationId)
    {
        if(medicationMapper.findById(medicationId).isMedicationExpiration())
        {
            return true;
        }
        else
        {
            return reminderService.checkMedicationExpiration(medicationId);
        }
    }
}

