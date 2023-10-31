package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.model.FacilityType;
import com.swp391.FacilityFeedbackApplication.repository.FacilityTypeRepository;
import com.swp391.FacilityFeedbackApplication.service.CampusService;
import com.swp391.FacilityFeedbackApplication.service.FacilityTypeService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/facility-type")
public class FacilityTypeController {
    @Autowired
    private FacilityTypeService facilityTypeService;
    @GetMapping("/view")
    public List<FacilityType> getAllFacilityType(){
        return facilityTypeService.getFacilityType();
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<?> find(@PathVariable int id){
//        return ResponseEntity.status(HttpStatus.OK).body(facilityTypeService.findFacilityTypeById(id));
//    }
    @PostMapping("/create")
    public ResponseEntity<?> addFacilityType(@RequestBody FacilityType facilityType){
        if (facilityTypeService.isFacilityTypeDuplicated(facilityType.getName())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility type name duplicated!!!");
        }else {
            if (facilityType.isStatus() == Boolean.parseBoolean(null)){
                facilityType.setStatus(true);
            }
            if (facilityTypeService.createFacilityType(facilityType)){
                return ResponseEntity.status(HttpStatus.OK).body("Add successfully !!!!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create failed!!!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFacilityType(@RequestBody FacilityType facilityType, @PathVariable int id){
        if (facilityTypeService.isFacilityTypeDuplicated(facilityType.getName())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility type name duplicated!!!");
        }else{
            if (facilityTypeService.findFacilityTypeById(id) == null || facilityType == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility type not found");
            } else {
                if (facilityTypeService.editFacilityType(id, facilityType)){
                    return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update failed !!!!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFacilityType(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(facilityTypeService.deleteFacilityType(id));
    }
}
