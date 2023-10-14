package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.DTO.Staff.loginDTO;
import com.swp391.FacilityFeedbackApplication.model.Staff;
import com.swp391.FacilityFeedbackApplication.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStaff(){
        return ResponseEntity.status(HttpStatus.OK).body(staffService.getAllStaff());
    }
    @GetMapping("/getAllByCampusId/{campusId}")
    public ResponseEntity<?> getAllByCampusId(@PathVariable int campusId){
        return ResponseEntity.status(HttpStatus.OK).body(staffService.getStaffByCampusId(campusId));
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findStaffById (@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(staffService.searchStaffById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addStaff(@RequestBody Staff staff){
        if(staffService.isLoginNameDupplicated(staff.getLoginName())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LoginName is dupplicated !");
        }else{
            if (staffService.addStaff(staff)){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Add staff failed");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable int id, @RequestBody Staff staff){
        if (staffService.searchStaffById(id) == null || staff == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }else{
            if (staffService.editStaff(staff, id)){
                return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update staff failed");
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(staffService.deleteStaffByStatus(id));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody loginDTO loginDTO){
        String loginName = loginDTO.getLoginName();
        String password = loginDTO.getPassword();
        Staff staff = staffService.login(loginName, password);
        if (staff != null) {
            return ResponseEntity.status(HttpStatus.OK).body(staff);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid loginName or password");
        }
    }

    @GetMapping("/search/{fullName}")
    public ResponseEntity<?> findStaffByFullName(@PathVariable("fullName") String fullName){
        Staff st =staffService.searchStaffByFullName(fullName);
        if (st != null){
            return ResponseEntity.status(HttpStatus.OK).body(st);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find staff");
    }


//    public Staff login(@RequestBody String loginName, @RequestBody String password){
//        return staffService.checkLogin(loginName, password);
//    }

    //public Staff login (RequestBody String l, @RequestBody password) {

//        String loginName = staff.getLoginName();
//        String password = staff.getPassword();
        //return staffService.checkLogin(loginName, password);
//        if (st.isManager()){
//            return "admin page";
//        }else{
//            return "staff page";
//        }
 //   }

}
