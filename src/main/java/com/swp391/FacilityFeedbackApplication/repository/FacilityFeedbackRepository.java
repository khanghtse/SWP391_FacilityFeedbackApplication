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
    @Query(value = "SELECT FacilityFeedback.Id, Description, Image, Createdate, C.CampusName, F.FloorName, FP.FacilityProblemName, R.RoomName, F2.FacilityName\n" +
            "FROM FacilityFeedback\n" +
            "INNER JOIN Campus C ON FacilityFeedback.CampusId = C.Id\n" +
            "INNER JOIN Floor F ON FacilityFeedback.FloorId = F.Id\n" +
            "INNER JOIN FacilityProblem FP ON FacilityFeedback.FacilityProblemId = FP.Id\n" +
            "INNER JOIN Room R ON FacilityFeedback.RoomId = R.Id\n" +
            "INNER JOIN Facility F2 ON FacilityFeedback.FacilityId = F2.Id", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> getAllFeedback();
}
