package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    @Query(value = "SELECT [Id],[RoomTypeName],[Status] FROM [dbo].[RoomType]\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Transactional
    RoomType findRoomType(int id);
}
