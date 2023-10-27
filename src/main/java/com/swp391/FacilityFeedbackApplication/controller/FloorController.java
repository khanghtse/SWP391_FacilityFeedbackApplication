package com.swp391.FacilityFeedbackApplication.controller;
import com.swp391.FacilityFeedbackApplication.model.Floor;
import com.swp391.FacilityFeedbackApplication.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FloorController {
    @Autowired
    private FloorService floorService;
    @GetMapping("/floor")
    public List<Floor> getAllFloor(){
        return floorService.getFloor();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(floorService.findByCampusId(id));
    }
}