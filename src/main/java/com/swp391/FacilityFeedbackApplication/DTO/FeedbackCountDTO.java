package com.swp391.FacilityFeedbackApplication.DTO;

public class FeedbackCountDTO {
    private int totalFeedback;
    private int trueStatusFeedback;
    private int falseStatusFeedback;

    public int getTotalFeedback() {
        return totalFeedback;
    }

    public void setTotalFeedback(int totalFeedback) {
        this.totalFeedback = totalFeedback;
    }

    public int getTrueStatusFeedback() {
        return trueStatusFeedback;
    }

    public void setTrueStatusFeedback(int trueStatusFeedback) {
        this.trueStatusFeedback = trueStatusFeedback;
    }

    public int getFalseStatusFeedback() {
        return falseStatusFeedback;
    }

    public void setFalseStatusFeedback(int falseStatusFeedback) {
        this.falseStatusFeedback = falseStatusFeedback;
    }
}
