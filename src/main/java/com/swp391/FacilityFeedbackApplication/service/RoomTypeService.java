package com.swp391.FacilityFeedbackApplication.service;

import com.swp391.FacilityFeedbackApplication.model.RoomType;
import com.swp391.FacilityFeedbackApplication.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<RoomType> getRoomType() {
        return roomTypeRepository.findAll();
    }

    public RoomType findById(int id){
        return roomTypeRepository.findRoomType(id);
    }

    public boolean createRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
        return true;
    }

    public boolean isRoomTypeDuplicated(String name){
        try{
            return (roomTypeRepository.findRoomTypeByName(name) != null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean editRoomType(int id, RoomType roomType){
        try{
            return roomTypeRepository.updateRoomType(roomType.getName(), id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRoomType(int id){
        try{
            return roomTypeRepository.deleteRoomTypeByStatus(id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}