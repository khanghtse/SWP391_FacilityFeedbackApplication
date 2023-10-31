package com.swp391.FacilityFeedbackApplication.controller;
import com.swp391.FacilityFeedbackApplication.model.Room;
import com.swp391.FacilityFeedbackApplication.model.RoomType;
import com.swp391.FacilityFeedbackApplication.service.RoomService;
import com.swp391.FacilityFeedbackApplication.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/get-all/{id}")
    public ResponseEntity<?> getAllRoom(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoom(id));
    }
    @GetMapping("/view")
    public ResponseEntity<?> viewAllRoom(){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRoom());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findRoomById(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.searchRoomById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> addRoom(@RequestBody Room room){
        if (roomService.isRoomNameDupplicated(room.getName(), room.getCampusId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room name is dupplicated");
        }else {
            if (room.isStatus() == Boolean.parseBoolean(null)){
                room.setStatus(true);
            }
            if (roomService.createRoom(room)){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create room failed !!!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.deleteRoom(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable int id, @RequestBody Room room){
        if (roomService.isRoomNameDupplicated(room.getName(), room.getCampusId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room name is dupplicated");
        }else {
            if (roomService.searchRoomById(id) == null || room == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
            }else{
                if (roomService.editRoom(room, id)){
                    return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update room failed");
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable int id){
//        return ResponseEntity.status(HttpStatus.OK).body(roomService.deleteRoom(id));
//    }
}
