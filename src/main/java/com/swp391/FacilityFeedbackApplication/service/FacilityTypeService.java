package com.swp391.FacilityFeedbackApplication.service;


import com.swp391.FacilityFeedbackApplication.model.FacilityType;
import com.swp391.FacilityFeedbackApplication.repository.FacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService {
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;

    public List<FacilityType> getFacilityType(){
        return facilityTypeRepository.findAll();
    }
}
