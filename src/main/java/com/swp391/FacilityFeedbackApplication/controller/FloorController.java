package com.swp391.FacilityFeedbackApplication.controller;
import com.swp391.FacilityFeedbackApplication.model.Floor;
import com.swp391.FacilityFeedbackApplication.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FloorController {
    @Autowired
    private FloorService floorService;
    @GetMapping("/floor")
    public List<Floor> getAllFloor(){
        return floorService.getFloor();
    }
}