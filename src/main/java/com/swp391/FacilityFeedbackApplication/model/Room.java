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
    @Column(name = "Status")
    private boolean status;
    @Column(name = "RoomTypeId")
    private int roomTypeId;
    @Column(name = "FloorId")
    private int floorId;
    @Column(name = "CampusId")
    private int campusId;

    public Room() {
    }

    public Room(int id, String name, boolean status, int roomTypeId, int floorId, int campusId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.roomTypeId = roomTypeId;
        this.floorId = floorId;
        this.campusId = campusId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }
}
