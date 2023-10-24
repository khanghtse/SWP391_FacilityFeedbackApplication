package com.swp391.FacilityFeedbackApplication.DTO;

import org.springframework.web.multipart.MultipartFile;

public class RepairHistoryDTO {
    private int id;
    private String repairDate;

    private boolean status;
    private byte[] image;
    private String description;
    private int facilityFeedbackId;
    private String staffName;

    public RepairHistoryDTO() {
    }

    public RepairHistoryDTO(int id, String repairDate, boolean status, byte[] image, String description, int facilityFeedbackId, String staffName) {
        this.id = id;
        this.repairDate = repairDate;
        this.status = status;
        this.image = image;
        this.description = description;
        this.facilityFeedbackId = facilityFeedbackId;
        this.staffName=staffName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
