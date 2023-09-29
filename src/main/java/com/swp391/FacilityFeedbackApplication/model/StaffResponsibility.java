package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "StaffResponsibility")
public class StaffResponsibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "StaffId")
    private int staffId;
    @Column(name = "FacilityTypeId")
    private int facilityTypeId;

    public StaffResponsibility() {
    }

    public StaffResponsibility(int id, int staffId, int facilityTypeId) {
        this.id = id;
        this.staffId = staffId;
        this.facilityTypeId = facilityTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }
}
