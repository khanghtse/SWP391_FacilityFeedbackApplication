package com.swp391.FacilityFeedbackApplication.service;
import com.swp391.FacilityFeedbackApplication.DTO.RoomDTO;
import com.swp391.FacilityFeedbackApplication.model.Room;
import com.swp391.FacilityFeedbackApplication.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


    @Service
    public class RoomService {
        @Autowired
        private RoomRepository roomRepository;

        public List<RoomDTO> getRoom(int campusId){
            List<Object[]> results = roomRepository.getAllRoomByCampus(campusId);
            List<RoomDTO> roomDTOList = new ArrayList<>();

            for (Object[] result: results){
                RoomDTO roomDTO = new RoomDTO((int) result[0], (String) result[1], (boolean) result[2],
                        (String) result[3], (String) result[4], (String) result[5]);
                roomDTOList.add(roomDTO);
            }
            return roomDTOList;
        }

        public List<Room> getAllRoom(){
            return roomRepository.findAll();
        }
        public List<RoomDTO> searchRoomById(int id){
            List<Object[]> results = roomRepository.serachRoomById(id);
            List<RoomDTO> roomDTOList = new ArrayList<>();

            for (Object[] result: results){
                RoomDTO roomDTO = new RoomDTO((int) result[0], (String) result[1], (boolean) result[2],
                        (String) result[3], (String) result[4], (String) result[5]);
                roomDTOList.add(roomDTO);
            }
            return roomDTOList;
        }

        public boolean createRoom(Room room){
            roomRepository.save(room);
            return true;
        }

//        public boolean createRoom(Room room){
//            roomRepository.addRoom(room.getName(), room.isStatus(), room.getRoomTypeId(), room.getFloorId(), room.getCampusId());
//            return true;
//        }

        public boolean isRoomNameDupplicated(String name, int id){
            try{
                return (roomRepository.findRoomByRoomNameAndCampusId(name, id) != null);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

        public boolean deleteRoom(int id){
            try{
                return roomRepository.deleteRoomByStatus(id) == 1;
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }

        public boolean editRoom(Room room, int id){
            try{
                return roomRepository.updateRoomById(room.getName(), room.getRoomTypeId(), id) == 1;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

//        public boolean deleteRoom(int id){
//            roomRepository.deleteById(id);
//            return true;
//        }


    }

