package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.Floor;
import com.swp391.FacilityFeedbackApplication.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {
    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> getFloor(){
        return floorRepository.findAll();
    }

    public List<Floor> findByCampusId(int id){
        return floorRepository.findFloorByCampusId(id);
    }
}
