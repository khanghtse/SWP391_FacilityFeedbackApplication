package com.swp391.FacilityFeedbackApplication.DTO.Staff;


import lombok.Data;


public class loginDTO {
    private String loginName;
    private String password;

    public loginDTO() {
    }

    public loginDTO(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
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
}
