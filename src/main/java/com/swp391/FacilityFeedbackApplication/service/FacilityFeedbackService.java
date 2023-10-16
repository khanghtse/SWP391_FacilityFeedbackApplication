package com.swp391.FacilityFeedbackApplication.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import com.swp391.FacilityFeedbackApplication.repository.FacilityFeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityFeedbackService {
    private FacilityFeedbackRepository facilityFeedbackRepository;

    public List<FacilityFeedback> getAllFeedback() {
        return facilityFeedbackRepository.findAll();
    }

    public FacilityFeedback createFeedback(FacilityFeedback facilityFeedback){
        return facilityFeedbackRepository.save(facilityFeedback);
    }
}
