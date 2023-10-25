package com.example.arthricare.controller;


import com.example.arthricare.bean.Reminder;
import com.example.arthricare.bean.valueObject.HomePageData;
import com.example.arthricare.bean.valueObject.MyMedPageReminderData;
import com.example.arthricare.service.ReminderService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderController {
    @Resource
    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping("/createReminder")
    public void createReminder(@RequestBody Reminder reminder)
    {
        //reminderService.createReminder(reminder);
    }

    @GetMapping("findNextReminderTime/{medicationId}")
    public ResponseEntity<MyMedPageReminderData> findNextReminderTime(@PathVariable("medicationId") Long medicationId) {
        return  ResponseEntity.ok(reminderService.findNextReminderTime(medicationId));
    }

    @PostMapping("/takeMedication")
    public void processDate(@RequestBody HomePageData homePageData) {

        reminderService.takeMedication(homePageData.getReminderId(),homePageData.getTakeMedTime());

    }

    @GetMapping("checkMedicationTakeTimes/{medicationId}")
    public ResponseEntity<String> checkMedicationExpiration(@PathVariable("medicationId") Long medicationId) {
        return ResponseEntity.ok(reminderService.checkMedicationTakeTime(medicationId));
    }

    @GetMapping("findUniqueReminderTimeByMedicationId/{medicationId}")
    public ResponseEntity<List<Time>> findUniqueReminderTimeByMedicationId(@PathVariable("medicationId") Long medicationId) {
        return ResponseEntity.ok(reminderService.findUniqueReminderTimeByMedicationId(medicationId));
    }

}
