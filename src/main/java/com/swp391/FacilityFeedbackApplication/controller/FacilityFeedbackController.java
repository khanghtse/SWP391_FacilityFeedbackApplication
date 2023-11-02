package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.DTO.FeedbackCountDTO;
import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import com.swp391.FacilityFeedbackApplication.service.FacilityFeedbackService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/feedback")
public class FacilityFeedbackController {
    @Autowired
    private FacilityFeedbackService facilityFeedbackService;

    @PostMapping("/create")
    public ResponseEntity<String> createFeedback(
            @RequestBody String description,
            @RequestParam("image") MultipartFile image,
            //@RequestBody Date createDate,
            @RequestBody boolean status,
            @RequestBody int campusId,
            @RequestBody int floorId,
            @RequestBody int facilityProblemId,
            @RequestBody int roomId,
            @RequestBody int facilityId
    ){
        try{
            Date createDate = new Date();
            //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            FacilityFeedback facilityFeedback = new FacilityFeedback();
            facilityFeedback.setDesc(description);
            facilityFeedback.setImage(image.getBytes());
            facilityFeedback.setCreateDate(createDate);
            facilityFeedback.setStatus(status);
            facilityFeedback.setCampusId(campusId);
            facilityFeedback.setFloorId(floorId);
            facilityFeedback.setFacilityProblemId(facilityProblemId);
            facilityFeedback.setRoomId(roomId);
            facilityFeedback.setFacilityId(facilityId);
            FacilityFeedback saveFeedback = facilityFeedbackService.createFeedback(facilityFeedback);
            if(saveFeedback != null){
                return new ResponseEntity<>("Feedback create successfully", HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>("Failed to create feedback", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (IOException e){
            return new ResponseEntity<>("Failed to process image", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/getAll/{campusId}")
    public ResponseEntity<?> getAllFeedback(@PathVariable int campusId){
        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.getAllFeedback(campusId));
    }
    @GetMapping("/get-feedback/{Id}")
    public ResponseEntity<?> getAllFeedbackById(@PathVariable int Id){
        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.getAllFeedbackById(Id));
    }
//    @GetMapping("/view-report")
//    public ResponseEntity<?> countFeedbackInDateRange(@RequestParam("startDate") String startDate,
//                                                      @RequestParam("endDate") String endDate){
//        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.countFeedbackInDateRange(startDate, endDate));
//    }
//    @GetMapping("/view-report-true")
//    public ResponseEntity<?> countFeedbackWithTrueStatus(@RequestParam("startDate") String startDate,
//                                                         @RequestParam("endDate") String endDate){
//        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.countFeedbackWithTrueStatus(startDate, endDate));
//    }
//
//    @GetMapping("/view-report-false")
//    public ResponseEntity<?> countFeedbackWithFalseStatus(@RequestParam("startDate") String startDate,
//                                                         @RequestParam("endDate") String endDate){
//        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.countFeedbackWithFalseStatus(startDate, endDate));
//    }
    @GetMapping("/report")
    public ResponseEntity<?> countFeedback(@RequestParam("startDate") Date startDate,
                                           @RequestParam("endDate") Date endDate){
        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.countFeedback(startDate, endDate));
    }
}
