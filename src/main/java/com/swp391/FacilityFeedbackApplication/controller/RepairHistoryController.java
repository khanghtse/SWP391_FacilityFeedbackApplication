package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.DTO.RepairHistoryDTO;
import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import com.swp391.FacilityFeedbackApplication.service.FacilityFeedbackService;
import com.swp391.FacilityFeedbackApplication.service.RepairHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/repair")
public class RepairHistoryController {
    @Autowired
    private RepairHistoryService repairHistoryService;
    @Autowired
    private FacilityFeedbackService facilityFeedbackService;

    @PostMapping("/create")
    public ResponseEntity<?> addRepairHistory(@RequestBody boolean status,
                                              @RequestParam("image") MultipartFile image,
                                              @RequestBody String description,
                                              @RequestBody int facilityFeedbackId,
                                              @RequestBody int staffId){
        try{
            boolean finishedExists = repairHistoryService.existsByFacilityFeedbackIdAndStatus(facilityFeedbackId, true);
            if (finishedExists){
                return new ResponseEntity<>("This feedback was already finished", HttpStatus.BAD_REQUEST);
            }
            Date repairDate = new Date();
            //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            RepairHistory repairHistory = new RepairHistory();
            repairHistory.setRepairDate(repairDate);
            repairHistory.setStatus(status);
            repairHistory.setImage(image.getBytes());
            repairHistory.setDescription(description);
            repairHistory.setFacilityFeedbackId(facilityFeedbackId);
            repairHistory.setStaffId(staffId);
            RepairHistory saveRepairhistory = repairHistoryService.create(repairHistory);
            if (saveRepairhistory != null){
                FacilityFeedback facilityFeedback = facilityFeedbackService.findById(facilityFeedbackId);
                if (facilityFeedback != null){
                    if(!saveRepairhistory.isStatus()){
                        facilityFeedback.setStatus(false);
                    }else {
                        facilityFeedback.setStatus(true);
                    }
                    facilityFeedbackService.createFeedback(facilityFeedback);
                }
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

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(int id){
        return ResponseEntity.status(HttpStatus.OK).body(repairHistoryService.findRepairHistoryById(id));
    }
    @GetMapping("/viewAll/{id}")
    public ResponseEntity<?> viewByCampus(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(repairHistoryService.viewRepairHistory(id));
    }

    @GetMapping("/view-repair-history")
    public ResponseEntity<?> getAllRepairHistory(@RequestParam("campusId") int campusId,
                                                 @RequestParam("startDate") Date startDate,
                                                 @RequestParam("endDate") Date endDate){
        return ResponseEntity.status(HttpStatus.OK).body(repairHistoryService.getAllRepairHistory(campusId, startDate, endDate));
    }
}
