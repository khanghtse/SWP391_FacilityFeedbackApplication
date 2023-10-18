package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query( value = "SELECT s.[Id], s.[FullName],s.[LoginName],s.[Password],s.[IsManager],s.[Status],c.CampusName\n" +
            "from [dbo].[Staff] s INNER JOIN [dbo].[Campus] c ON s.[CampusId] = c.[Id]\n" +
            "WHERE s.[Status] = 1 AND [CampusId] = :campusId ", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> findByCampusId(int campusId);

    @Query(value = "SELECT s.[Id], s.[FullName],s.[LoginName],s.[Password],s.[IsManager],s.[Status],c.CampusName \n" +
            "from [dbo].[Staff] s INNER JOIN [dbo].[Campus] c ON s.[CampusId] = c.[Id]\n" +
            "WHERE s.[Status] = 1", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllStaff();

//    @Query(value = "SELECT [Id], [FullName], [LoginName], [Password], [IsManager], [Status], [CampusId]\n" +
//            "FROM [dbo].[Staff] WHERE [LoginName] = :loginName AND [Password] = :password", nativeQuery = true)
//    @Modifying
//    @Transactional
//    Staff findStaffByLoginNameAndPassword(@Param("loginName") String loginName,@Param("password") String password);

    Staff findStaffByLoginNameAndPassword(String loginName, String password);

    Staff findStaffByLoginName(String loginName);

    List<Staff> findStaffByFullNameLike(String fullName);

    Staff findStaffById(int id);
    @Query(value = "UPDATE [dbo].[Staff] SET [Status] = 'false' WHERE [Id] = :Id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateStaffStatus(@Param("Id") int id);


    @Query(value = "UPDATE [dbo].[Staff] SET [Password] = :Password, [CampusId] = :CampusId, [Status] = 'true' WHERE [Id] = :Id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateStaffById(@Param("Password") String password, @Param("CampusId") int campusId, @Param("Id") int id);


}
