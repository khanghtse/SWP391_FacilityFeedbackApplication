package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import com.swp391.FacilityFeedbackApplication.repository.FacilityProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityProblemService {
    @Autowired
    private FacilityProblemRepository facilityProblemRepository;

    public List<FacilityProblem> getFacilityProblem(){
        return facilityProblemRepository.findAll();
    }
}
