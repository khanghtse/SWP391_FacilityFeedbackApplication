package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Staff;
import com.swp391.FacilityFeedbackApplication.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/getAll")
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }
    @GetMapping("/getAllByCampusId/{campusId}")
    public List<Staff> getAllByCampusId(@PathVariable int campusId){
        return staffService.getStaffByCampusId(campusId);
    }
    @GetMapping("/find/{id}")
    public Optional<Staff> findStaffById (@PathVariable int id){
        return staffService.findStaff(id);
    }
    @PostMapping("/add")
    public Staff addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }
    @PutMapping("/update")
    public Staff updateStaff(@RequestParam("id") int id, @RequestBody Staff staff){
        return staffService.editStaff(id, staff);
    }
    @DeleteMapping("/delete/")
    public boolean deleteStaff(@RequestParam("id") int id){
        return staffService.deleteStaff(id);
    }
    //@GetMapping("/getStaffByCampus/{campusId}")
    //public List<Staff> getStaffByCampusId(@PathVariable int campusId){
    //    return staffService.getAllStaffByCampusId();
    //}

}
