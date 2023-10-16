package com.swp391.FacilityFeedbackApplication.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Campus")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CampusName")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Contact")
    private String contact;
//    @OneToMany(mappedBy = "campus")
//    private List<Staff> staffList;

    public Campus() {
    }

//    public Campus(int id, String name, String address, String contact, List<Staff> staffList) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.contact = contact;
//        this.staffList = staffList;
//    }

    public Campus(int id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }


//    public List<Staff> getStaffList() {
//        return staffList;
//    }
//
//    public void setStaffList(List<Staff> staffList) {
//        this.staffList = staffList;
//    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
