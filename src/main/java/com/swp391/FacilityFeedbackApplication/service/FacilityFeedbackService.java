package com.swp391.FacilityFeedbackApplication.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.swp391.FacilityFeedbackApplication.DTO.FacilityFeedbackDTO;
import com.swp391.FacilityFeedbackApplication.DTO.StaffDTO;
import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import com.swp391.FacilityFeedbackApplication.repository.FacilityFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacilityFeedbackService {
    @Autowired
    private FacilityFeedbackRepository facilityFeedbackRepository;

    public List<FacilityFeedbackDTO> getAllFeedback(int campusId){
        List<Object[]> results = facilityFeedbackRepository.getAllFeedback(campusId);
        List<FacilityFeedbackDTO> feedbackDTOList = new ArrayList<>();

        for (Object[] result: results){
            FacilityFeedbackDTO facilityFeedbackDTO = new FacilityFeedbackDTO((int) result[0], (String) result[1],
                    (byte[]) result[2], (String) result[3], (String) result[4], (String) result[5], (String) result[6],
                    (String) result[7],(String) result[8]);
            feedbackDTOList.add(facilityFeedbackDTO);
        }
        return feedbackDTOList;
    }

    public FacilityFeedback createFeedback(FacilityFeedback facilityFeedback){
        return facilityFeedbackRepository.save(facilityFeedback);
    }
    public List<FacilityFeedbackDTO> getAllFeedbackById(int id){
        List<Object[]> results = facilityFeedbackRepository.getAllFeedbackById(id);
        List<FacilityFeedbackDTO> feedbackDTOList = new ArrayList<>();

        for (Object[] result: results){
            FacilityFeedbackDTO facilityFeedbackDTO = new FacilityFeedbackDTO((int) result[0], (String) result[1],
                    (byte[]) result[2], (String) result[3], (String) result[4], (String) result[5], (String) result[6],
                    (String) result[7],(String) result[8]);
            feedbackDTOList.add(facilityFeedbackDTO);
        }
        return feedbackDTOList;
    }


//    public FacilityFeedback view(int id){
//        return facilityFeedbackRepository.findAllById(id);
//    }

}
