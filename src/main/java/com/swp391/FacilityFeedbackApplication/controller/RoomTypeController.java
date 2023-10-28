package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.RoomType;
import com.swp391.FacilityFeedbackApplication.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/roomType")
    public List<RoomType> getAllRoomType() {
        return roomTypeService.getRoomType();
    }
    @GetMapping("/find-room-type/{id}")
    public RoomType findRoomType(@PathVariable("id") int id){
        return roomTypeService.findById(id);
    }
}