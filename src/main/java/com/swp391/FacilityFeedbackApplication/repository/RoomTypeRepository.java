package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    @Query(value = "SELECT [Id],[RoomTypeName],[Status] FROM [dbo].[RoomType]\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Transactional
    RoomType findRoomType(int id);
    @Query(value = "SELECT [Id],[RoomTypeName],[Status] FROM [dbo].[RoomType]\n" +
            "WHERE [RoomTypeName] = :name", nativeQuery = true)
    @Transactional
    RoomType findRoomTypeByName(@Param("name") String name);
    @Query(value = "UPDATE [dbo].[RoomType] SET [RoomTypeName] = :name\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateRoomType(@Param("name") String name, @Param("id") int id);
    @Query(value = "UPDATE [dbo].[RoomType] SET [Status] = 'false'\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer deleteRoomTypeByStatus(@Param("id") int id);
}
