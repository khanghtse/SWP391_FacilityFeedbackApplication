package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.RepairHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface RepairHistoryRepository extends JpaRepository<RepairHistory, Integer> {
    boolean existsByFacilityFeedbackIdAndStatus(int id, boolean status);
    @Query(value = "SELECT rp.[Id], rp.[RepairDate], rp.[Status], rp.[Image], rp.[Description], rp.[FacilityFeedbackId], s.FullName AS StaffName\n" +
            "FROM [dbo].[RepairHistory] rp\n" +
            "INNER JOIN [dbo].[FacilityFeedback] FF ON rp.FacilityFeedbackId = FF.Id\n" +
            "INNER JOIN [dbo].[Staff] s ON rp.StaffId = s.Id\n" +
            "WHERE FF.CampusId = :campusId ORDER BY rp.RepairDate DESC", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllByCampus(int campusId);

    @Query(value = "SELECT rp.[Id], rp.[RepairDate], rp.[Status], rp.[Image], rp.[Description], rp.[FacilityFeedbackId], s.FullName AS StaffName\n" +
            "FROM [dbo].[RepairHistory] rp\n" +
            "INNER JOIN [dbo].[Staff] s ON rp.StaffId = s.Id\n" +
            "WHERE rp.[Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> findRepairHistoryById (int id);

    @Query(value = "SELECT rp.[Id], rp.[RepairDate], rp.[Status], rp.[Image], rp.[Description], rp.[FacilityFeedbackId], s.FullName AS StaffName\n" +
            "            FROM [dbo].[RepairHistory] rp\n" +
            "            INNER JOIN [dbo].[FacilityFeedback] FF ON rp.FacilityFeedbackId = FF.Id\n" +
            "            INNER JOIN [dbo].[Staff] s ON rp.StaffId = s.Id\n" +
            "            WHERE FF.CampusId = :campusId AND rp.RepairDate BETWEEN :startDate AND :endDate  \n" +
            "\t\t\tORDER BY s.Id DESC , rp.RepairDate DESC", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllRepairHistory(@Param("campusId") int campusId,
                                       @Param("startDate")Date startDate,
                                       @Param("endDate") Date endDate);


}