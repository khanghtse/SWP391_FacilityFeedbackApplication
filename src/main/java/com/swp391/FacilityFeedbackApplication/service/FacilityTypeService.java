package com.swp391.FacilityFeedbackApplication.service;


import com.swp391.FacilityFeedbackApplication.DTO.FacilityTypeDTO;
import com.swp391.FacilityFeedbackApplication.model.FacilityType;
import com.swp391.FacilityFeedbackApplication.repository.FacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityTypeService {
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;

    public List<FacilityType> getFacilityType(){
        return facilityTypeRepository.findAll();
    }

    public List<FacilityTypeDTO> viewAllFacilityType(){
        List<Object[]> results = facilityTypeRepository.viewAllRoom();
        List<FacilityTypeDTO> facilityTypeDTOList = new ArrayList<>();

        for (Object[] result: results){
            FacilityTypeDTO facilityTypeDTO = new FacilityTypeDTO((int) result[0], (String) result[1],
                    (boolean) result[2], (String) result[3]);
            facilityTypeDTOList.add(facilityTypeDTO);
        }
        return facilityTypeDTOList;
    }

    public boolean isFacilityTypeDuplicated(String name){
        try{
            return facilityTypeRepository.findFacilityTypeByName(name) != null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean createFacilityType(FacilityType facilityType){
        facilityTypeRepository.save(facilityType);
        return true;
    }

    public FacilityType findFacilityTypeById(int id){
        return facilityTypeRepository.findFacilityTypeById(id);
    }

    public boolean editFacilityType(int id, FacilityType facilityType){
        try{
            return facilityTypeRepository.updateFacilityType(facilityType.getName(), facilityType.getRoomTypeId(), id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFacilityType(int id){
        try{
            return facilityTypeRepository.deleteFacilityTypeByStatus(id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
