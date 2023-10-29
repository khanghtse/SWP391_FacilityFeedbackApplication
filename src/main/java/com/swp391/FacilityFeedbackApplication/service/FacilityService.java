package com.swp391.FacilityFeedbackApplication.service;
import com.swp391.FacilityFeedbackApplication.DTO.FacilityDTO;
import com.swp391.FacilityFeedbackApplication.model.Facility;
import com.swp391.FacilityFeedbackApplication.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    public class FacilityService {
        @Autowired
        private FacilityRepository facilityRepository;

        public List<FacilityDTO> getFacility(){
            List<Object[]> results = facilityRepository.getAllFacility();
            List<FacilityDTO> facilityDTOList = new ArrayList<>();

            for (Object[] result: results){
                FacilityDTO facilityDTO = new FacilityDTO((int) result[0], (String) result[1], (double) result[2],
                        (boolean) result[3], (String) result[4], (String) result[5]);
                facilityDTOList.add(facilityDTO);
            }
            return facilityDTOList;
        }

        public List<Facility> getAllFacility(){
            return facilityRepository.findAll();
        }

        public List<FacilityDTO> getFacilityById(int id){
            List<Object[]> results = facilityRepository.getAllFacilityById(id);
            List<FacilityDTO> facilityDTOList = new ArrayList<>();

            for (Object[] result: results){
                FacilityDTO facilityDTO = new FacilityDTO((int) result[0], (String) result[1], (double) result[2],
                        (boolean) result[3], (String) result[4], (String) result[5]);
                facilityDTOList.add(facilityDTO);
            }
            return facilityDTOList;
        }

        public boolean editFacility(Facility facility, int id){
            try{
                return facilityRepository.updateFacility(facility.getName(), facility.getQuantity(), id) == 1;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

        public Facility findFacilityById(int id){
            try{
                return facilityRepository.findFacilityById(id);
            }catch (Exception e){
                e.printStackTrace();

            }
            return null;
        }

        public boolean createFacility(Facility facility){
            facilityRepository.save(facility);
            return true;
        }

        public boolean isFacilityNameDuplicated(String name){
            try{
                return (facilityRepository.findFacilityByName(name) != null);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

//        public boolean deleteFacilityByStatus(int id){
//            try{
//                return facilityRepository.deleteFacilityByStatus(id) == 1;
//            }catch (Exception e){
//                e.printStackTrace();
//                return false;
//            }
//        }
}
