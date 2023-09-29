package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CampusController {
    @Autowired
    private CampusService campusService;
    @GetMapping("/campus")
    public List<Campus> getAllCampus(){
        return campusService.getCampus();
    }
}
