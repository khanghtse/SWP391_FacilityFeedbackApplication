package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "RoomName")
    private String name;
    @Column(name = "RoomTypeId")
    private int roomTypeId;
    @Column(name = "FloorId")
    private int floorId;

    public Room() {
    }

    public Room(int id, String name, int roomTypeId, int floorId) {
        this.id = id;
        this.name = name;
        this.roomTypeId = roomTypeId;
        this.floorId = floorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
}
