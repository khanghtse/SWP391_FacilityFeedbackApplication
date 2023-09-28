package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.repository.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusService {
    @Autowired
    private CampusRepository campusRepository;

    public List<Campus> getCampus(){
        return campusRepository.findAll();
    }
}
