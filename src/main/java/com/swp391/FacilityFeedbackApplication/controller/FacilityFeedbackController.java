package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import com.swp391.FacilityFeedbackApplication.service.FacilityFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api/feedback")
public class FacilityFeedbackController {
    @Autowired
    private FacilityFeedbackService facilityFeedbackService;

    @PostMapping("/create")
    public ResponseEntity<String> createFeedback(
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image,
            @RequestParam("createDate") Date createDate,
            @RequestParam("campusId") int campusId,
            @RequestParam("floorId") int floorId,
            @RequestParam("facilityProblemId") int facilityProblemId,
            @RequestParam("roomId") int roomId,
            @RequestParam("facilityId") int facilityId
    ){
        try{
            FacilityFeedback facilityFeedback = new FacilityFeedback();
            facilityFeedback.setDesc(description);
            facilityFeedback.setImage(image.getBytes());
            facilityFeedback.setCreateDate(createDate);
            facilityFeedback.setCampusId(campusId);
            facilityFeedback.setFloorId(floorId);
            facilityFeedback.setFacilityProblemId(facilityProblemId);
            facilityFeedback.setRoomId(roomId);
            facilityFeedback.setFacilityId(facilityId);
            FacilityFeedback saveFeeback = facilityFeedbackService.createFeedback(facilityFeedback);
            if(saveFeeback != null){
                return new ResponseEntity<>("Feedback create successfully", HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>("Failed to create feedback", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (IOException e){
            return new ResponseEntity<>("Failed to process image", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
