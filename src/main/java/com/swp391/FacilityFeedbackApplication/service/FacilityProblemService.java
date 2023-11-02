package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.DTO.FacilityProblemDTO;
import com.swp391.FacilityFeedbackApplication.DTO.ProblemReportDTO;
import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import com.swp391.FacilityFeedbackApplication.repository.FacilityProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

//    public List<FeedbackReportDTO> countFeedback(Date startDate, Date endDate, int id){
//        List<Object[]> results = facilityFeedbackRepository.countFeedback(startDate, endDate, id);
//        List<FeedbackReportDTO> dtos = new ArrayList<>();
//
//        for(Object[] result: results){
//            FeedbackReportDTO dto = new FeedbackReportDTO();
//            dto.setTotalFeedback((int) result[0]);
//            dto.setTrueStatusFeedback((int) result[1]);
//            dto.setFalseStatusFeedback((int) result[2]);
//            dtos.add(dto);
//        }
//        return dtos;
//    }

    public List<ProblemReportDTO> countProblem(Date startDate,Date endDate, int id){
        List<Object[]> results = facilityProblemRepository.countProblem(startDate, endDate, id);
        List<ProblemReportDTO> dtos = new ArrayList<>();

        for (Object[] result: results){
            ProblemReportDTO dto = new ProblemReportDTO();
            dto.setFeedbackCount((int) result[0]);
            dto.setProblemName((String) result[1]);
            dtos.add(dto);
        }
        return dtos;
    }

    public boolean isProblemNameDuplicated(String name){
        try {
            return (facilityProblemRepository.findProblemByName(name) != null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean addProblem(FacilityProblem facilityProblem){
        facilityProblemRepository.save(facilityProblem);
        return true;
    }

    public boolean editProblem(int id, FacilityProblem facilityProblem){
        try{
            return facilityProblemRepository.updateFacilityProblem(facilityProblem.getProblemName(),
                    facilityProblem.getFacilityTypeId(), id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public FacilityProblem findProblemById(int id){
        try{
            return facilityProblemRepository.findFacilityProblemById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
