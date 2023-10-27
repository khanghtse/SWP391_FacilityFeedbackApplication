package com.swp391.FacilityFeedbackApplication.DTO;

public class FacilityProblemDTO {
    private int id;
    private String facilityProblemName;
    private boolean status;
    private String facilityTypeName;

    public FacilityProblemDTO(int id, String facilityProblemName, boolean status, String facilityTypeName) {
        this.id = id;
        this.facilityProblemName = facilityProblemName;
        this.status = status;
        this.facilityTypeName = facilityTypeName;
    }

    public FacilityProblemDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacilityProblemName() {
        return facilityProblemName;
    }

    public void setFacilityProblemName(String facilityProblemName) {
        this.facilityProblemName = facilityProblemName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }
}
