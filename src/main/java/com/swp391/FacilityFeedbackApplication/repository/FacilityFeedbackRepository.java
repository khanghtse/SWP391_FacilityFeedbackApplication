package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.FacilityFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FacilityFeedbackRepository extends JpaRepository<FacilityFeedback, Integer> {
    @Query(value = "SELECT f.Id, Description, Image, Createdate, C.CampusName, Fl.FloorName, FP.FacilityProblemName, R.RoomName, F2.FacilityName\n" +
            "FROM FacilityFeedback f\n" +
            "INNER JOIN Campus C ON f.CampusId = C.Id\n" +
            "INNER JOIN Floor Fl ON f.FloorId = Fl.Id\n" +
            "INNER JOIN FacilityProblem FP ON f.FacilityProblemId = FP.Id\n" +
            "INNER JOIN Room R ON f.RoomId = R.Id\n" +
            "INNER JOIN Facility F2 ON f.FacilityId = F2.Id\n" +
            "WHERE f.[CampusId] = :campusId", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllFeedback(int campusId);
}
