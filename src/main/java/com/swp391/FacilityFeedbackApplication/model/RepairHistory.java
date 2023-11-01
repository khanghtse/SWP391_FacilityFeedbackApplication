package com.swp391.FacilityFeedbackApplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RepairHistory")
public class RepairHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "RepairDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date repairDate;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "Image")
    private byte[] image;
    @Column(name = "Description")
    private String description;
    @Column(name = "FacilityFeedbackId")
    private int facilityFeedbackId;
    @Column(name = "StaffId")
    private int staffId;

    public RepairHistory() {
    }

    public RepairHistory(int id, Date repairDate, boolean status, byte[] image, String description, int facilityFeedbackId, int staffId) {
        this.id = id;
        this.repairDate = repairDate;
        this.status = status;
        this.image = image;
        this.description = description;
        this.facilityFeedbackId = facilityFeedbackId;
        this.staffId = staffId;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
