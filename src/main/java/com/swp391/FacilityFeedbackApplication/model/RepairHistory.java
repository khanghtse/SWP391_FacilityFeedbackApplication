package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RepairHistory")
public class RepairHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Time")
    private int time;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "FacilityFeedbackId")
    private int facilityFeedbackId;
    @Column(name = "StaffId")
    private int staffId;

    public RepairHistory(int id, int time, boolean status, int facilityFeedbackId, int staffId) {
        this.id = id;
        this.time = time;
        this.status = status;
        this.facilityFeedbackId = facilityFeedbackId;
        this.staffId = staffId;
    }

    public RepairHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFacilityFeedbackId() {
        return facilityFeedbackId;
    }

    public void setFacilityFeedbackId(int facilityFeedbackId) {
        this.facilityFeedbackId = facilityFeedbackId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
