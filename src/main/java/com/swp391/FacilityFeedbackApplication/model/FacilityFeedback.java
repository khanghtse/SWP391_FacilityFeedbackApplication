package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "FacilityFeedback")
public class FacilityFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Description")
    private String desc;
    @Column(name = "FacilityProblemId")
    private int facilityProblemId;
    @Column(name = "RoomId")
    private int roomId;
    @Column(name = "FacilityId")
    private int facilityId;
    @Column(name = "CreateDate")
    private Date createDate;
    @Column(name = "CampusId")
    private int campusId;
    @Column(name = "FloorId")
    private int floorId;


    public FacilityFeedback() {
    }

    public FacilityFeedback(int id, String desc, int facilityProblemId, int roomId, int facilityId, Date createDate, int campusId, int floorId) {
        this.id = id;
        this.desc = desc;
        this.facilityProblemId = facilityProblemId;
        this.roomId = roomId;
        this.facilityId = facilityId;
        this.createDate = createDate;
        this.campusId = campusId;
        this.floorId = floorId;
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
}
