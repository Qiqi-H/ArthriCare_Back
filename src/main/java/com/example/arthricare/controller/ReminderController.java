package com.example.arthricare.controller;


import com.example.arthricare.bean.Reminder;
import com.example.arthricare.bean.valueObject.HomePageData;
import com.example.arthricare.bean.valueObject.MyMedPageReminderData;
import com.example.arthricare.service.ReminderService;
import com.example.arthricare.service.UserRewardService;
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
    private final UserRewardService userRewardService;

    public ReminderController(ReminderService reminderService, UserRewardService userRewardService) {
        this.reminderService = reminderService;
        this.userRewardService = userRewardService;
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
        System.out.println(homePageData);
        userRewardService.updatePuzzleNum(homePageData.getUserId());
    }

    @GetMapping("checkMedicationTakeTimes/{medicationId}")
    public ResponseEntity<String> checkMedicationExpiration(@PathVariable("medicationId") Long medicationId) {
        return ResponseEntity.ok(reminderService.checkMedicationTakeTime(medicationId));
    }

    @GetMapping("findUniqueReminderTimeByMedicationId/{medicationId}")
    public ResponseEntity<List<Time>> findUniqueReminderTimeByMedicationId(@PathVariable("medicationId") Long medicationId) {
        return ResponseEntity.ok(reminderService.findUniqueReminderTimeByMedicationId(medicationId));
    }

    @GetMapping("findReminderByReminderId/{reminderId}")
    public ResponseEntity<Reminder> findReminderByReminderId(@PathVariable("reminderId") Long reminderId) {
        return ResponseEntity.ok(reminderService.findReminderByReminderId(reminderId));
    }

}
