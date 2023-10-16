package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "LoginName")
    private String loginName;
    @Column(name = "Password")
    private  String password;
    @Column(name = "IsManager")
    private  boolean isManager;
//    @ManyToOne
//    @JoinColumn(name = "CampusId")
//    private Campus campus;
    @Column(name = "CampusId")
    private int campusId;
    @Column(name = "Status")
    private boolean status;

    public Staff() {
    }

//    public Staff(int id, String fullName, String loginName, String password, boolean isManager, Campus campus, boolean status) {
//        this.id = id;
//        this.fullName = fullName;
//        this.loginName = loginName;
//        this.password = password;
//        this.isManager = isManager;
//        this.campus = campus;
//        this.status = status;
//    }

    public Staff(int id, String fullName, String loginName, String password, boolean isManager, int campusId, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.loginName = loginName;
        this.password = password;
        this.isManager = isManager;
        this.campusId = campusId;
        this.status = status;
    }


//    public Campus getCampus() {
//        return campus;
//    }
//
//    public void setCampus(Campus campus) {
//        this.campus = campus;
//    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }
}
