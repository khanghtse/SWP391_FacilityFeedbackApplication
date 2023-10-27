package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Facility;
import com.swp391.FacilityFeedbackApplication.service.FacilityService;
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
    @RequestMapping("/api/facility")
    public class FacilityController {
        @Autowired
        private FacilityService facilityService;
        @GetMapping("/view")
        public ResponseEntity<?> getAllFacility(){
            return ResponseEntity.status(HttpStatus.OK).body(facilityService.getFacility());
        }
    }
