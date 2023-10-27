package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT [Id],[RoomName],[RoomTypeId],[FloorId],[CampusId] FROM [dbo].[Room]\n" +
            "WHERE [RoomName] = :name AND [CampusId] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Room findRoomByRoomNameAndCampusId(@Param("name") String name, @Param("id") int id);
    @Query(value = "UPDATE [dbo].[Room] SET [Status] = 'false' WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer deleteRoomByStatus(@Param("id") int id);
    @Query(value = "SELECT r.[Id], r.[RoomName], r.[Status], rt.RoomTypeName, fl.FloorName, c.CampusName FROM [dbo].[Room] r\n" +
            "INNER JOIN [dbo].[RoomType] rt ON r.RoomTypeId = rt.Id\n" +
            "INNER JOIN [dbo].[Floor] fl ON r.FloorId = fl.Id\n" +
            "INNER JOIN [dbo].[Campus] c ON r.CampusId = c.Id\n" +
            "WHERE r.[Status] = 'true' AND r.CampusId = :campusId", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllRoomByCampus(int campusId);
    @Query(value = "SELECT r.[Id], r.[RoomName], r.[Status], rt.RoomTypeName, fl.FloorName, c.CampusName FROM [dbo].[Room] r\n" +
            "INNER JOIN [dbo].[RoomType] rt ON r.RoomTypeId = rt.Id\n" +
            "INNER JOIN [dbo].[Floor] fl ON r.FloorId = fl.Id\n" +
            "INNER JOIN [dbo].[Campus] c ON r.CampusId = c.Id\n" +
            "WHERE r.[Status] = 'true' AND r.Id = :id", nativeQuery = true)
    List<Object[]> serachRoomById(int id);


//    @Query(value = "INSERT INTO [dbo].[Room] ([RoomName],[Status],[RoomTypeId],[FloorId],[CampusId])\n" +
//            "VALUES (:roomName, :status, :roomTypeId, :floorId, :campusId)", nativeQuery = true)
//    Integer addRoom(@Param("roomName") String name, @Param("status") boolean status,
//                    @Param("roomTypeId") int roomTypeId, @Param("floorId") int floorId, @Param("campusId") int campusId);
    @Query(value = "UPDATE [dbo].[Room] SET [RoomName] = :roomName, [RoomTypeId] = :roomTypeId, [Status] = 'true'\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateRoomById(@Param("roomName") String roomName, @Param("roomTypeId") int roomTypeId, @Param("id") int id);


}
