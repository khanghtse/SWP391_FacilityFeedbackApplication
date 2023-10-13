package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.model.FacilityType;
import com.swp391.FacilityFeedbackApplication.repository.FacilityTypeRepository;
import com.swp391.FacilityFeedbackApplication.service.CampusService;
import com.swp391.FacilityFeedbackApplication.service.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacilityTypeController {
    @Autowired
    private FacilityTypeService facilityTypeService;
    @GetMapping("/facilitytype")
    public List<FacilityType> getAllFacilityType(){
        return facilityTypeService.getFacilityType();
    }
}
