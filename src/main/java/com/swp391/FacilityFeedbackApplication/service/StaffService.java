package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.Staff;
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

    public Staff addStaff(Staff staff){
        if (staff != null){
            return staffRepository.save(staff);
        }else{
            return null;
        }
    }

    public Staff editStaff(int id, Staff staff){
        if (staff != null){
            Staff st = staffRepository.getReferenceById(id);
            if (st != null){
                st.setFullName(st.getFullName());
                st.setLoginName(st.getLoginName());
                st.setPassword(st.getPassword());
                st.setManager(false);
            }
        }
        return null;
    }

    public boolean deleteStaff(int id){
        if (id >= 1){
            Staff staff = staffRepository.getReferenceById(id);
            if (staff != null){
                staffRepository.delete(staff);
            }
            return true;
        }
        return false;
    }


}
