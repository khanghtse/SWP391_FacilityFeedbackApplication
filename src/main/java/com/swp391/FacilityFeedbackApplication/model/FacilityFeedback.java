package com.swp391.FacilityFeedbackApplication.model;

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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "CreateDate")
    private String createDate;
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


    public FacilityFeedback() {
    }

    public FacilityFeedback(int id, String desc, byte[] image, String createDate,
                            int campusId, int floorId, int facilityProblemId, int roomId,
                            int facilityId) {
        this.id = id;
        this.desc = desc;
        this.image = image;
        this.createDate = createDate;
        this.campusId = campusId;
        this.floorId = floorId;
        this.facilityProblemId = facilityProblemId;
        this.roomId = roomId;
        this.facilityId = facilityId;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
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
