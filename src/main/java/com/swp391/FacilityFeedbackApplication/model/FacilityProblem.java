package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FacilityProblem")
public class FacilityProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FacilityProblemName")
    private String problemName;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "FacilityTypeId")
    private int facilityTypeId;

    public FacilityProblem() {
    }

    public FacilityProblem(int id, String problemName, boolean status, int facilityTypeId) {
        this.id = id;
        this.problemName = problemName;
        this.status = status;
        this.facilityTypeId = facilityTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }
}
