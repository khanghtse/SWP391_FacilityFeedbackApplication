package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.DTO.StaffDTO;
import com.swp391.FacilityFeedbackApplication.model.Staff;
import com.swp391.FacilityFeedbackApplication.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public List<Staff> getAllStaff(){
//        return staffRepository.getAllStaff();
//    }

    public List<StaffDTO> getAllStaff(){
        List<Object[]> results = staffRepository.getAllStaff();
        List<StaffDTO> staffDtoList = new ArrayList<>();

        for(Object[] result: results){
            StaffDTO staffDTO = new StaffDTO((int) result[0], (String) result[1],(String) result[2],
                    (String) result[3], (boolean) result[4], (boolean) result[5], (String) result[6]);
            staffDtoList.add(staffDTO);
        }
        return staffDtoList;
    }

    public List<StaffDTO> getStaffByCampusId(int campusId) {
        List<Object[]> results = staffRepository.findByCampusId(campusId);
        List<StaffDTO> staffDTOList = new ArrayList<>();

        for (Object[] result: results){
            StaffDTO staffDTO = new StaffDTO((int) result[0], (String) result[1],(String) result[2],
                    (String) result[3], (boolean) result[4], (boolean) result[5], (String) result[6]);
            staffDTOList.add(staffDTO);
        }
        return staffDTOList;
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
            return staffRepository.updateStaffById(staff.getPassword(), staff.getCampusId(), id) == 1;
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
//            if (password.equals(staffRepository.findStaffByLoginName(loginName).getPassword())){
//                return staffRepository.findStaffByLoginName(loginName);
//            }else{
//                return null;
//            }
            return staffRepository.findStaffByLoginNameAndPassword(loginName, password);
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
