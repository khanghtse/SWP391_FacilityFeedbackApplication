package com.swp391.FacilityFeedbackApplication.service;
import com.swp391.FacilityFeedbackApplication.model.Facility;
import com.swp391.FacilityFeedbackApplication.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class FacilityService {
        @Autowired
        private FacilityRepository facilityRepository;

        public List<Facility> getFacility(){
            return facilityRepository.findAll();
        }
}
