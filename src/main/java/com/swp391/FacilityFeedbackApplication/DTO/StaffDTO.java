package com.swp391.FacilityFeedbackApplication.DTO;

public class StaffDTO {
    private int id;
    private String fullName;
    private String loginName;
    private String password;
    private boolean isManager;
    private boolean status;
    private String campusName;

    public StaffDTO(int id, String fullName, String loginName, String password, boolean isManager, boolean status, String campusName) {
        this.id = id;
        this.fullName = fullName;
        this.loginName = loginName;
        this.password = password;
        this.isManager = isManager;
        this.status = status;
        this.campusName = campusName;
    }

    public StaffDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
