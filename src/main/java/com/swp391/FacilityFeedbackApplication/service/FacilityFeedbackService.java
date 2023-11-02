package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.DTO.FacilityFeedbackDTO;
import com.swp391.FacilityFeedbackApplication.DTO.FeedbackReportDTO;
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
                    (byte[]) result[2], (Date) result[3], (boolean) result[4], (String) result[5], (String) result[6], (String) result[7],
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
                    (byte[]) result[2], (Date) result[3], (boolean) result[4], (String) result[5], (String) result[6], (String) result[7],
                    (String) result[8],(String) result[9]);
            feedbackDTOList.add(facilityFeedbackDTO);
        }
        return feedbackDTOList;
    }

    public FacilityFeedback findById(int id){
        return facilityFeedbackRepository.findFacilityFeedbackById(id);
    }

//    public Long countFeedbackInDateRange(String startDate, String endDate){
//        return facilityFeedbackRepository.countFeedbackInDateRange(startDate, endDate);
//    }
//
//    public Long countFeedbackWithTrueStatus(String startDate, String endDate){
//        return facilityFeedbackRepository.countFeedbackWithTrueStatus(startDate, endDate);
//    }
//
//    public Long countFeedbackWithFalseStatus(String startDate, String endDate){
//        return facilityFeedbackRepository.countFeedbackWithFalseStatus(startDate, endDate);
//    }

    public List<FeedbackReportDTO> countFeedback(Date startDate, Date endDate, int id){
        try{
            List<Object[]> results = facilityFeedbackRepository.countFeedback(startDate, endDate, id);
            List<FeedbackReportDTO> dtos = new ArrayList<>();

            for(Object[] result: results){
                FeedbackReportDTO dto = new FeedbackReportDTO();
                dto.setTotalFeedback((int) result[0]);
                dto.setTrueStatusFeedback((int) result[1]);
                dto.setFalseStatusFeedback((int) result[2]);
                dtos.add(dto);
            }
            return dtos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


//    public FacilityFeedback view(int id){
//        return facilityFeedbackRepository.findAllById(id);
//    }

}
