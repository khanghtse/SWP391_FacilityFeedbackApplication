package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FacilityName")
    private String name;
    @Column(name = "Quantity")
    private double quantity;
    @Column(name = "FacilityTypeId")
    private int facilityTypeId;

    public Facility() {
    }

    public Facility(int id, String name, double quantity, int facilityTypeId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.facilityTypeId = facilityTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }
}
