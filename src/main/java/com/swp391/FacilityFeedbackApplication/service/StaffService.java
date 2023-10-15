package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.Staff;
import com.swp391.FacilityFeedbackApplication.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public List<Staff> getStaffByCampusId(int campusId) {
        try{
            return staffRepository.findByCampusId(campusId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Staff searchStaffById(int id){
        try{
            return staffRepository.findStaffById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public boolean addStaff(Staff staff){
        if (staff != null){
            staffRepository.save(staff);
            return true;
        }else{
            return false;
        }
    }

    public boolean editStaff(Staff staff, int id){
        try{
            return staffRepository.updateStaffById(staff.getFullName(), staff.getLoginName(),
                    staff.getPassword(), staff.isManager(), staff.isStatus(), staff.getCampusId(), id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//    public boolean deleteStaff(int id){
//        if (id >= 1){
//            Staff staff = staffRepository.getReferenceById(id);
//            if (staff != null){
//                staffRepository.delete(staff);
//            }
//            return true;
//        }
//        return false;
//    }

    public boolean deleteStaffByStatus(int id){
        try{
            return staffRepository.updateStaffStatus(id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//    public Staff checkLogin(String loginName, String password){
//        return staffRepository.findStaffByLoginNameAndPassword(loginName, password);
//    }
    public Staff login(String loginName, String password){
        try {
            if (password.equals(staffRepository.findStaffByLoginName(loginName).getPassword())){
                return staffRepository.findStaffByLoginName(loginName);
            }else{
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Staff> searchStaffByFullName(String fullName){
        try{
           return staffRepository.findStaffByFullNameLike("%"+fullName+"%");
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean isLoginNameDupplicated(String loginName){
        try{
            return (staffRepository.findStaffByLoginName(loginName) != null);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
