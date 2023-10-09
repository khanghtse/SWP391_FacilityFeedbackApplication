package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RepairHistory")
public class RepairHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "RepairDate")
    private Date repairDate;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "FacilityFeedbackId")
    private int facilityFeedbackId;
    @Column(name = "StaffId")
    private int staffId;

    public RepairHistory(int id, Date repairDate, boolean status, int facilityFeedbackId, int staffId) {
        this.id = id;
        this.repairDate = repairDate;
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

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
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
