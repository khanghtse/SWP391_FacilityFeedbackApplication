package com.swp391.FacilityFeedbackApplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "FacilityFeedback")
public class FacilityFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Description")
    private String desc;
    @Column(name = "Image")
    private byte[] image;

    @Column(name = "CreateDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date createDate;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "CampusId")
    private int campusId;
    @Column(name = "FloorId")
    private int floorId;
    @Column(name = "FacilityProblemId")
    private int facilityProblemId;
    @Column(name = "RoomId")
    private int roomId;
    @Column(name = "FacilityId")
    private int facilityId;
    @Column(name = "StaffId")
    private int staffId;


    public FacilityFeedback() {
    }

    public FacilityFeedback(int id, String desc, byte[] image, Date createDate, boolean status,
                            int campusId, int floorId, int facilityProblemId, int roomId,
                            int facilityId, int staffId) {
        this.id = id;
        this.desc = desc;
        this.image = image;
        this.createDate = createDate;
        this.status = status;
        this.campusId = campusId;
        this.floorId = floorId;
        this.facilityProblemId = facilityProblemId;
        this.roomId = roomId;
        this.facilityId = facilityId;
        this.staffId = staffId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getFacilityProblemId() {
        return facilityProblemId;
    }

    public void setFacilityProblemId(int facilityProblemId) {
        this.facilityProblemId = facilityProblemId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
