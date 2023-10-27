package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Facility;
import com.swp391.FacilityFeedbackApplication.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//        @DeleteMapping("/delete/{id}")
//        public ResponseEntity<?> deleteFacility(@PathVariable int id){
//            return ResponseEntity.status(HttpStatus.OK).body(facilityService.deleteFacilityByStatus(id));
//        }
    }
