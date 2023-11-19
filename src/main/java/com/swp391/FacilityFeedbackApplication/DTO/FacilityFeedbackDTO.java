package com.swp391.FacilityFeedbackApplication.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FacilityFeedbackDTO {
    private int id;
    private String description;
    private byte[] image;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date createDate;
    private boolean status;
    private String campusName;
    private String floorName;
    private String facilityProblemName;
    private String roomName;
    private String facilityName;
    //private String staffName;

    public FacilityFeedbackDTO() {
    }

    public FacilityFeedbackDTO(int id, String description, byte[] image,
                               Date createDate, boolean status, String campusName, String floorName,
                               String facilityProblemName, String roomName, String facilityName) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.createDate = createDate;
        this.status = status;
        this.campusName = campusName;
        this.floorName = floorName;
        this.facilityProblemName = facilityProblemName;
        this.roomName = roomName;
        this.facilityName = facilityName;
        //this.staffName = staffName;
    }

//    public String getStaffName() {
//        return staffName;
//    }
//
//    public void setStaffName(String staffName) {
//        this.staffName = staffName;
//    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFacilityProblemName() {
        return facilityProblemName;
    }

    public void setFacilityProblemName(String facilityProblemName) {
        this.facilityProblemName = facilityProblemName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}
