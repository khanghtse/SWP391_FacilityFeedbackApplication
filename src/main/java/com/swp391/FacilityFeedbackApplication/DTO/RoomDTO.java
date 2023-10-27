package com.swp391.FacilityFeedbackApplication.DTO;

public class RoomDTO {
    private int id;
    private String roomName;
    private boolean status;
    private String roomTypeName;
    private String floorName;
    private String campusName;

    public RoomDTO() {
    }

    public RoomDTO(int id, String roomName, boolean status, String roomTypeName, String floorName, String campusName) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
        this.roomTypeName = roomTypeName;
        this.floorName = floorName;
        this.campusName = campusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
