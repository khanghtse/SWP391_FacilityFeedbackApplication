package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.DTO.FacilityFeedbackDTO;
import com.swp391.FacilityFeedbackApplication.DTO.FacilityProblemDTO;
import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import com.swp391.FacilityFeedbackApplication.repository.FacilityProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityProblemService {
    @Autowired
    private FacilityProblemRepository facilityProblemRepository;

    public List<FacilityProblem> getFacilityProblem(){
        return facilityProblemRepository.findAll();
    }

    public List<FacilityProblemDTO> getAllProblem(){
        List<Object[]> results = facilityProblemRepository.getAllProblem();
        List<FacilityProblemDTO> feedbackDTOList = new ArrayList<>();

        for (Object[] result: results){
            FacilityProblemDTO facilityProblemDTO = new FacilityProblemDTO((int) result[0], (String) result[1], (boolean) result[2], (String) result[3]);
            feedbackDTOList.add(facilityProblemDTO);
        }
        return feedbackDTOList;
    }
}
