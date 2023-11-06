package com.example.arthricare.controller;

import com.example.arthricare.bean.Medication;
import com.example.arthricare.bean.valueObject.HomePageData;
import com.example.arthricare.bean.valueObject.HomePageMedData;
import com.example.arthricare.service.MedicationService;
import com.example.arthricare.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {
    private final MedicationService medicationService;
    private final ReminderService reminderService;

    @Autowired
    public MedicationController(MedicationService medicationService,ReminderService reminderService) {

        this.medicationService = medicationService;
        this.reminderService = reminderService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMedication(@RequestBody Medication medication) {

        try{
            medicationService.createMedication(medication);
            return ResponseEntity.ok("successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add medication.");
        }
    }

    @PutMapping("/updateMedication")
    public ResponseEntity<Void> updateMedication(@RequestBody Medication medication) {
        medicationService.updateMedication(medication);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable("id") Integer id) {
        Medication medication = medicationService.getMedicationById(id);
        if (medication != null) {
            return ResponseEntity.ok(medication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Medication>> getAllMedications() {
        List<Medication> medications = medicationService.getAllMedications();
        return ResponseEntity.ok(medications);
    }

    @GetMapping("findMedicationByUserId/{userId}")
    public ResponseEntity<List<Medication>> findMedicationByUserId(@PathVariable("userId") int userId) {
        List<Medication> medications = medicationService.findMedicationByUserId(userId);
        //Medication m = medications.get(0);
        if (!medications.isEmpty()) {
            //System.out.println(medications);
            return ResponseEntity.ok(medications);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/findMedicationByUserIdAndDate")
    public ResponseEntity<List<HomePageMedData>> findMedicationByUserIdAndDate(@RequestBody HomePageData homePageData) {

        System.out.println(medicationService.findMedicationByUserIdAndDate(homePageData));
        return ResponseEntity.ok(medicationService.findMedicationByUserIdAndDate(homePageData));
    }



    @GetMapping("checkMedicationExpiration/{medicationId}")
    public ResponseEntity<Boolean> checkMedicationExpiration(@PathVariable("medicationId") int medicationId) {
        if (medicationService.checkMedicationExpiration(medicationId))
        {
            medicationService.updateMedicationExpirationStatues(medicationId,true);
            return  ResponseEntity.ok(true);
        }
        else
        {
            medicationService.updateMedicationExpirationStatues(medicationId,false);
            return  ResponseEntity.ok(false);
        }
    }

    @PutMapping("updateMedicationExpiration/{medicationId}")
    public ResponseEntity<String> updateMedicationExpiration(@PathVariable("medicationId") int medicationId)
    {
        medicationService.updateMedicationExpirationStatues(medicationId,true);

        return  ResponseEntity.ok(reminderService.checkMedicationTakeTime(medicationId));
    }

    @DeleteMapping("deleteMedication/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable("medicationId") int medicationId)
    {
        medicationService.deleteMedication(medicationId);
        return  ResponseEntity.ok("delete Success");
    }
    //https://www.runoob.com/w3cnote/javascript-autocomplete.html
    //qu dou dong
    //https://medium.com/@milosbiljanovic/springboot-autocomplete-with-elasticsearch-11ea95d58854
    //https://www.bilibili.com/video/BV1yg411P7yY/?p=29&vd_source=c9077c6b6818570388f7a98e1e585429
}


