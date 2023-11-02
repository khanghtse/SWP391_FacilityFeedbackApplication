package com.swp391.FacilityFeedbackApplication.DTO;

public class FacilityTypeDTO {
    private int id;
    private String facilityTypeName;
    private boolean status;
    private String roomTypeName;

    public FacilityTypeDTO() {
    }

    public FacilityTypeDTO(int id, String facilityTypeName, boolean status, String roomTypeName) {
        this.id = id;
        this.facilityTypeName = facilityTypeName;
        this.status = status;
        this.roomTypeName = roomTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
}
