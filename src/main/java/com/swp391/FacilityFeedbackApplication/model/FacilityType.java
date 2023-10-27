package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FacilityType")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FacilityTypeName")
    private String name;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "RoomTypeId")
    private int roomTypeId;

    public FacilityType() {
    }

    public FacilityType(int id, String name, boolean status, int roomTypeId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.roomTypeId = roomTypeId;
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
}
