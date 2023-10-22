package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairHistoryRepository extends JpaRepository<RepairHistory, Integer> {
    boolean existsByFacilityFeedbackIdAndStatus(int id, boolean status);
}