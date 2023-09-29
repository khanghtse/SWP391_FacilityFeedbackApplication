package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.Staff;
import com.swp391.FacilityFeedbackApplication.model.StaffResponsibility;
import com.swp391.FacilityFeedbackApplication.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public boolean isExisted (int id){
        return staffRepository.existsById(id);
    }
    public Optional<Staff> findStaff(int id){
        return staffRepository.findById(id);
    }
}
