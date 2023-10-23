package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.DTO.FacilityFeedbackDTO;
import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import com.swp391.FacilityFeedbackApplication.repository.FacilityFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacilityFeedbackService {
    @Autowired
    private FacilityFeedbackRepository facilityFeedbackRepository;

    public List<FacilityFeedbackDTO> getAllFeedback(int campusId){
        List<Object[]> results = facilityFeedbackRepository.getAllFeedback(campusId);
        List<FacilityFeedbackDTO> feedbackDTOList = new ArrayList<>();

        for (Object[] result: results){
            FacilityFeedbackDTO facilityFeedbackDTO = new FacilityFeedbackDTO((int) result[0], (String) result[1],
                    (byte[]) result[2], (String) result[3], (boolean) result[4], (String) result[5], (String) result[6], (String) result[7],
                    (String) result[8],(String) result[9]);
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
                    (byte[]) result[2], (String) result[3], (boolean) result[4], (String) result[5], (String) result[6], (String) result[7],
                    (String) result[8],(String) result[9]);
            feedbackDTOList.add(facilityFeedbackDTO);
        }
        return feedbackDTOList;
    }

    public FacilityFeedback findById(int id){
        return facilityFeedbackRepository.findFacilityFeedbackById(id);
    }


//    public FacilityFeedback view(int id){
//        return facilityFeedbackRepository.findAllById(id);
//    }

}
