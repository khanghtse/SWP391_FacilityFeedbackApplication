package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
    FacilityType findFacilityTypeById(int id);
    @Query(value = "SELECT [Id],[FacilityTypeName],[Status],[RoomTypeId] FROM [dbo].[FacilityType]\n" +
            "WHERE [FacilityTypeName] = :name", nativeQuery = true)
    @Transactional
    FacilityType findFacilityTypeByName(String name);
    @Query(value = "UPDATE [dbo].[FacilityType] SET [FacilityTypeName] = :facilityTypeName, [RoomTypeId] = :roomTypeId\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateFacilityType(@Param("facilityTypeName") String facilityTypeName,
                               @Param("roomTypeId") int roomTypeId, @Param("id") int id);
    @Query(value = "UPDATE [dbo].[FacilityType] SET [Status] = 'false'\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer deleteFacilityTypeByStatus(@Param("id") int id);
}
