package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FacilityName")
    private String name;
    @Column(name = "Quantity")
    private double quantity;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "FacilityTypeId")
    private int facilityTypeId;
    @Column(name = "RoomTypeId")
    private int roomTypeId;

    public Facility() {
    }

    public Facility(int id, String name, double quantity, boolean status, int facilityTypeId, int roomTypeId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.facilityTypeId = facilityTypeId;
        this.roomTypeId = roomTypeId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
