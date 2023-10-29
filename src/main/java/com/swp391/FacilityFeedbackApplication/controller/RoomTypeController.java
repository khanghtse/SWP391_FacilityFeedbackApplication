package com.swp391.FacilityFeedbackApplication.controller;

import com.swp391.FacilityFeedbackApplication.model.Room;
import com.swp391.FacilityFeedbackApplication.model.RoomType;
import com.swp391.FacilityFeedbackApplication.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/room-type")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/view")
    public List<RoomType> getAllRoomType() {
        return roomTypeService.getRoomType();
    }

    @PostMapping("/create")
    public ResponseEntity<?> addRoomType(@RequestBody RoomType roomType) {
        if (roomTypeService.isRoomTypeDuplicated(roomType.getName())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RoomType name is duplicated");
        } else {
            if (roomType.isStatus() == Boolean.parseBoolean(null)) {
                roomType.setStatus(true);
            }
            if (roomTypeService.createRoomType(roomType)) {
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create room type failed");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoomType(@RequestBody RoomType roomType, @PathVariable int id){
        if (roomTypeService.findById(id) == null || roomType == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RoomType not found!!!!");
        }else {
            if (roomTypeService.editRoomType(id, roomType)){
                return ResponseEntity.status(HttpStatus.OK).body("Update successfully!!!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update failed !!!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoomType(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(roomTypeService.deleteRoomType(id));
    }
//    @GetMapping("/find-room-type/{id}")
//    public RoomType findRoomType(@PathVariable("id") int id){
//        return roomTypeService.findById(id);
//    }

}