package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Facility;
import com.swp391.FacilityFeedbackApplication.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class FacilityController {
        @Autowired
        private FacilityService facilityService;
        @GetMapping("/facility")
        public List<Facility> getAllFacility(){
            return facilityService.getFacility();
        }
    }