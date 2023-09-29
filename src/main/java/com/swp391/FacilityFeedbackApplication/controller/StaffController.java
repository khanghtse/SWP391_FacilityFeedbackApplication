package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Staff;
import com.swp391.FacilityFeedbackApplication.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }
    @GetMapping("/staff/{id}")
    public Optional<Staff> findStaffById (@PathVariable int id){
        return staffService.findStaff(id);
    }
}
