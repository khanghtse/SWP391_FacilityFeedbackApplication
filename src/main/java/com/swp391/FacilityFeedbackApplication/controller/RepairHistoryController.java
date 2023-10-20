package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import com.swp391.FacilityFeedbackApplication.service.RepairHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/repair")
public class RepairHistoryController {
    @Autowired
    private RepairHistoryService repairHistoryService;

    @PostMapping("/create")
    public ResponseEntity<?> addRepairHistory(@RequestBody boolean status,
                                              @RequestParam("image") MultipartFile image,
                                              @RequestBody String description,
                                              @RequestBody int facilityFeedbackId,
                                              @RequestBody int staffId){
        try{
            Date repairDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            RepairHistory repairHistory = new RepairHistory();
            repairHistory.setRepairDate(sdf.format(repairDate));
            repairHistory.setStatus(status);
            repairHistory.setImage(image.getBytes());
            repairHistory.setDescription(description);
            repairHistory.setFacilityFeedbackId(facilityFeedbackId);
            repairHistory.setStaffId(staffId);
            RepairHistory saveRepairhistory = repairHistoryService.create(repairHistory);
            if (saveRepairhistory != null){
                return new ResponseEntity<>("Feedback create successfully", HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>("Failed to create feedback", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to process image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllRepairHistory(){
        return ResponseEntity.status(HttpStatus.OK).body(repairHistoryService.getAllRepairHistory());
    }
}
