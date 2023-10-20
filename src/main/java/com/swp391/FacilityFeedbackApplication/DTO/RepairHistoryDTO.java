package com.swp391.FacilityFeedbackApplication.DTO;

import org.springframework.web.multipart.MultipartFile;

public class RepairHistoryDTO {
    private boolean status;
    private MultipartFile image;
    private String description;
    private int facilityFeedbackId;
    private int staffId;

    public RepairHistoryDTO() {
    }

    public RepairHistoryDTO(boolean status, MultipartFile image, String description, int facilityFeedbackId, int staffId) {
        this.status = status;
        this.image = image;
        this.description = description;
        this.facilityFeedbackId = facilityFeedbackId;
        this.staffId = staffId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
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
