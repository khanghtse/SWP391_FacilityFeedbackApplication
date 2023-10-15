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
    @Query( value = "SELECT [Id],[FullName],[LoginName],[Password],[IsManager],[Status],[CampusId]\n" +
            "FROM [dbo].[Staff]\n" +
            "WHERE [CampusId] = :campusId AND [IsManager] = 'false' ", nativeQuery = true)
    @Modifying
    @Transactional
    List<Staff> findByCampusId(int campusId);

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


    @Query(value = "UPDATE [dbo].[Staff] SET [FullName] = :FullName, [LoginName] = :LoginName," +
            " [Password] = :Password, [IsManager] = :IsManager, [Status] = :Status,[CampusId] = :CampusId\n" +
            "WHERE [Id] = :Id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateStaffById(@Param("FullName") String fullName, @Param("LoginName") String loginName, @Param("Password") String password,
                            @Param("IsManager") boolean isManager, @Param("Status") boolean status,
                            @Param("CampusId") int campusId, @Param("Id") int id);


}
