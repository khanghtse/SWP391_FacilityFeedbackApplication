package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.DTO.RepairHistoryDTO;
import com.swp391.FacilityFeedbackApplication.DTO.StaffDTO;
import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import com.swp391.FacilityFeedbackApplication.repository.RepairHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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


    public boolean existsByFacilityFeedbackIdAndStatus(int id, boolean status){
        return repairHistoryRepository.existsByFacilityFeedbackIdAndStatus(id, status);
    }

    public List<RepairHistoryDTO> viewRepairHistory(int id){
        List<Object[]> results = repairHistoryRepository.getAllByCampus(id);
        List<RepairHistoryDTO> repairHistoryDTOList = new ArrayList<>();

        for (Object[] result: results){
            RepairHistoryDTO repairHistoryDTO = new RepairHistoryDTO((int) result[0], (Date) result[1], (boolean) result[2],
                    (byte[]) result[3], (String) result[4], (int) result[5], (String) result [6]);
            repairHistoryDTOList.add(repairHistoryDTO);
        }
        return repairHistoryDTOList;
    }
    public List<RepairHistoryDTO> findRepairHistoryById (int id){
        List<Object[]> results = repairHistoryRepository.findRepairHistoryById(id);
        List<RepairHistoryDTO> repairHistoryDTOList = new ArrayList<>();

        for (Object[] result: results){
            RepairHistoryDTO repairHistoryDTO = new RepairHistoryDTO((int) result[0], (Date) result[1], (boolean) result[2],
                    (byte[]) result[3], (String) result[4], (int) result[5], (String) result [6]);
            repairHistoryDTOList.add(repairHistoryDTO);
        }
        return repairHistoryDTOList;
    }
}
