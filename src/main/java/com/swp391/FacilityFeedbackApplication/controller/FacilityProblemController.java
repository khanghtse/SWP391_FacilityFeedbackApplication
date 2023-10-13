package com.swp391.FacilityFeedbackApplication.controller;
import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import com.swp391.FacilityFeedbackApplication.service.FacilityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacilityProblemController{
    @Autowired
    private FacilityProblemService facilityProblemService;
    @GetMapping("/facilityProblem")
    public List<FacilityProblem> getAllFacilityProblem(){
        return facilityProblemService.getFacilityProblem();
    }
}
