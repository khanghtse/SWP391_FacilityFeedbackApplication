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
        @GetMapping("/get-all")
        public ResponseEntity<?> viewFacility(){
            return ResponseEntity.status(HttpStatus.OK).body(facilityService.getAllFacility());
        }
        @GetMapping("/find/{id}")
        public ResponseEntity<?> findFacilityById(int id){
            return ResponseEntity.status(HttpStatus.OK).body(facilityService.findFacilityById(id));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateFacility(@PathVariable int id, @RequestBody Facility facility){
            if (facilityService.isFacilityNameDuplicated(facility.getName())){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility name is duplicated !!");
            }else {
                if (facilityService.findFacilityById(id) == null || facility == null){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility not found");
                }else {
                    if (facilityService.editFacility(facility, id)){
                        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully!!");
                    }
                }
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update facility failed!!");
        }

        @PostMapping("/create")
        public ResponseEntity<?> addFacility(@RequestBody Facility facility){
            if (facilityService.isFacilityNameDuplicated(facility.getName())){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility name is duplicated !!");
            } else {
                if (facility.isStatus() == Boolean.parseBoolean(null)){
                    facility.setStatus(true);
                }
                if (facilityService.createFacility(facility)){
                    return ResponseEntity.status(HttpStatus.OK).body(true);
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create facility failed!!!");
        }

//        @DeleteMapping("/delete/{id}")
//        public ResponseEntity<?> deleteFacility(@PathVariable int id){
//            return ResponseEntity.status(HttpStatus.OK).body(facilityService.deleteFacilityByStatus(id));
//        }
    }
