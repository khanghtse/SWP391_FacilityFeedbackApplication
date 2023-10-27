package com.swp391.FacilityFeedbackApplication.controller;
import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import com.swp391.FacilityFeedbackApplication.service.FacilityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/facilityProblem")
public class FacilityProblemController{
    @Autowired
    private FacilityProblemService facilityProblemService;
    @GetMapping("/view-all")
    public ResponseEntity<?> getAllFacilityProblem(){
        return ResponseEntity.status(HttpStatus.OK).body(facilityProblemService.getAllProblem());
    }

}
