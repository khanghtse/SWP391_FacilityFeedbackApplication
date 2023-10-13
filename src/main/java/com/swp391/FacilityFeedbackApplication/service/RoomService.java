package com.swp391.FacilityFeedbackApplication.service;
import com.swp391.FacilityFeedbackApplication.model.Campus;
import com.swp391.FacilityFeedbackApplication.model.Room;
import com.swp391.FacilityFeedbackApplication.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class RoomService {
        @Autowired
        private RoomRepository roomRepository;

        public List<Room> getRoom(){
            return roomRepository.findAll();
        }
    }

