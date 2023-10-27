package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FacilityProblemRepository extends JpaRepository<FacilityProblem, Integer> {
    @Query(value = "SELECT FP.Id, \n" +
            "       FP.FacilityProblemName, \n" +
            "       FP.Status, \n" +
            "       FT.FacilityTypeName\n" +
            "FROM FacilityProblem FP\n" +
            "INNER JOIN FacilityType FT ON FP.FacilityTypeId = FT.Id\n", nativeQuery = true)

    @Modifying
    @Transactional


    List <Object[]> getAllProblem();

}
