package com.swp391.FacilityFeedbackApplication.DTO;

public class FacilityDTO {
    private int id;
    private String facilityName;
    private double quantity;
    private boolean status;
    private String facilityTypeName;
    private String roomTypeName;

    public FacilityDTO() {
    }

    public FacilityDTO(int id, String facilityName, double quantity, boolean status, String facilityTypeName, String roomTypeName) {
        this.id = id;
        this.facilityName = facilityName;
        this.quantity = quantity;
        this.status = status;
        this.facilityTypeName = facilityTypeName;
        this.roomTypeName = roomTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
}
