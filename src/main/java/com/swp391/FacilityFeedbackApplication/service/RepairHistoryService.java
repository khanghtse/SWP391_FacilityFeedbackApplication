package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import com.swp391.FacilityFeedbackApplication.repository.RepairHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairHistoryService {
    @Autowired
    private RepairHistoryRepository repairHistoryRepository;

    public RepairHistory create(RepairHistory repairHistory){
        try {
            return repairHistoryRepository.save(repairHistory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<RepairHistory> getAllRepairHistory(){
        return repairHistoryRepository.findAll();
    }

    public Optional<RepairHistory> findRepairHistoryById(int id){
        return repairHistoryRepository.findById(id);
    }
}
