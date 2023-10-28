package com.swp391.FacilityFeedbackApplication.controller;
import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import com.swp391.FacilityFeedbackApplication.service.FacilityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get-all")
    public ResponseEntity<?> viewFacilityProblem(){
        return ResponseEntity.status(HttpStatus.OK).body(facilityProblemService.getFacilityProblem());
    }

    @PostMapping("/create")
    public ResponseEntity<?> addProblem(@RequestBody FacilityProblem facilityProblem){
        if (facilityProblemService.isProblemNameDuplicated(facilityProblem.getProblemName())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem is duplicated!!!");
        } else {
            if (facilityProblem.isStatus() == Boolean.parseBoolean(null)){
                facilityProblem.setStatus(true);
            }
            if (facilityProblemService.addProblem(facilityProblem)){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create problem failed");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProblem(@PathVariable int id, @RequestBody FacilityProblem facilityProblem){
        if (facilityProblemService.findProblemById(id) == null || facilityProblem == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility problem not found");
        }else{
            if (facilityProblemService.editProblem(id, facilityProblem)){
                return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update problem failed");
    }

}
