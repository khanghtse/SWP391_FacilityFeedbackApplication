package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

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

    public FacilityFeedback() {
    }

    public FacilityFeedback(int id, String desc, int facilityProblemId, int roomId, int facilityId) {
        this.id = id;
        this.desc = desc;
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
}
