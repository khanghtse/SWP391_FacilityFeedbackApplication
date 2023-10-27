package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "SELECT f.[Id],[FacilityName],f.[Quantity],f.[Status],ft.FacilityTypeName,rt.RoomTypeName FROM [dbo].[Facility] f\n" +
            "INNER JOIN [dbo].[FacilityType] ft ON f.FacilityTypeId = ft.Id\n" +
            "INNER JOIN [dbo].[RoomType] rt ON f.RoomTypeId = rt.Id\n" +
            "WHERE f.[Status] = 'true'", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllFacility();

    @Query(value = "SELECT f.[Id],[FacilityName],f.[Quantity],f.[Status],ft.FacilityTypeName,rt.RoomTypeName FROM [dbo].[Facility] f\n" +
            "INNER JOIN [dbo].[FacilityType] ft ON f.FacilityTypeId = ft.Id\n" +
            "INNER JOIN [dbo].[RoomType] rt ON f.RoomTypeId = rt.Id\n" +
            "WHERE f.[Status] = 'true' AND f.Id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllFacilityById(int id);
}
