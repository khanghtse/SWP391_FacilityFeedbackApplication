package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query(value = "UPDATE [dbo].[Facility] SET [FacilityName] = :facilityName, [Quantity] = :quantity\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateFacility(@Param("facilityName") String facilityName, @Param("quantity") double quantity,
                           @Param("id") int id);

    Facility findFacilityById(int id);
    @Query(value = "SELECT [Id], [FacilityName], [Quantity], [Status], [FacilityTypeId], [RoomTypeId] FROM [dbo].[Facility]\n" +
            "WHERE [FacilityName] = :facilityName", nativeQuery = true)
    @Transactional
    Facility findFacilityByName(@Param("facilityName") String facilityName);
//    @Query(value = "UPDATE [dbo].[Facility] SET [Status] = 'false' WHERE [Id] = :id", nativeQuery = true)
//    @Modifying
//    @Transactional
//    Integer deleteFacilityByStatus(@Param("id") int id);
}
