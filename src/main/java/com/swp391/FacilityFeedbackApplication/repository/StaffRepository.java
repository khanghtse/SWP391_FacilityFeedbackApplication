package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query( value = "SELECT [Id],[FullName],[LoginName],[Password],[IsManager],[Status],[CampusId]\n" +
            "FROM [dbo].[Staff]\n" +
            "WHERE [CampusId] = :campusId AND [IsManager] = 'false' ", nativeQuery = true)

    List<Staff> findByCampusId(int campusId);
}
