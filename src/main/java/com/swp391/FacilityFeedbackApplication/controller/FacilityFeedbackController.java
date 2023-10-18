package com.swp391.FacilityFeedbackApplication.controller;

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
            @RequestBody int campusId,
            @RequestBody int floorId,
            @RequestBody int facilityProblemId,
            @RequestBody int roomId,
            @RequestBody int facilityId
    ){
        try{
            Date createDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String formatedCreateDate = sdf.format(createDate);
            FacilityFeedback facilityFeedback = new FacilityFeedback();
            facilityFeedback.setDesc(description);
            facilityFeedback.setImage(image.getBytes());
            facilityFeedback.setCreateDate(createDate);
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
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFeedback(){
        return ResponseEntity.status(HttpStatus.OK).body(facilityFeedbackService.getAllFeedback());
    }
}
