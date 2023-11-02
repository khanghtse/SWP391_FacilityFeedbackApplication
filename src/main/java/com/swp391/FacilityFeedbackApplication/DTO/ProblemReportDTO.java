package com.swp391.FacilityFeedbackApplication.DTO;

public class ProblemReportDTO {

    private int feedbackCount;
    private String problemName;

    public ProblemReportDTO() {
    }

    public ProblemReportDTO(int feedbackCount, String problemName) {
        this.feedbackCount = feedbackCount;
        this.problemName = problemName;
    }

    public int getFeedbackCount() {
        return feedbackCount;
    }

    public void setFeedbackCount(int feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }
}
