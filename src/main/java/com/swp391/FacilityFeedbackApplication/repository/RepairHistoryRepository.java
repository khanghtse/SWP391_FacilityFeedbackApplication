package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RepairHistoryRepository extends JpaRepository<RepairHistory, Integer> {
    boolean existsByFacilityFeedbackIdAndStatus(int id, boolean status);
    @Query(value = "SELECT rp.[Id],rp.[RepairDate],rp.[Status],rp.[Image],\n" +
            "rp.[Description],rp.[FacilityFeedbackId],\n" +
            "rp.[StaffId] FROM [dbo].[RepairHistory] rp\n" +
            "INNER JOIN [dbo].[FacilityFeedback] FF ON rp.FacilityFeedbackId = FF.Id\n" +
            "WHERE FF.CampusId = :campusId", nativeQuery = true)
    @Modifying
    @Transactional
    List<RepairHistory> getAllByCampus(int campusId);
}