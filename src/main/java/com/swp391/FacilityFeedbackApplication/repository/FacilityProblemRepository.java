package com.swp391.FacilityFeedbackApplication.repository;

import com.swp391.FacilityFeedbackApplication.model.FacilityProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Query(value = "SELECT [Id],[FacilityProblemName],[Status],[FacilityTypeId] FROM [dbo].[FacilityProblem]\n" +
            "WHERE [FacilityProblemName] = :name", nativeQuery = true)
    @Transactional
    FacilityProblem findProblemByName(@Param("name") String name);
    @Query(value = "UPDATE [dbo].[FacilityProblem] SET [FacilityProblemName] = :facilityProblemName, [FacilityTypeId] = :facilityTypeId\n" +
            "WHERE [Id] = :id", nativeQuery = true)
    @Modifying
    @Transactional
    Integer updateFacilityProblem(@Param("facilityProblemName") String facilityProblemName,
                                  @Param("facilityTypeId") int facilityTypeId,
                                  @Param("id") int id);
    FacilityProblem findFacilityProblemById(int id);
    @Query(value = "SELECT\n" +
            "    COUNT(ff.id) AS FeedbackCount,\n" +
            "    fp.FacilityProblemName AS ProblemName\n" +
            "FROM\n" +
            "    FacilityFeedback AS ff\n" +
            "JOIN\n" +
            "    FacilityProblem AS fp ON ff.facilityProblemId = fp.id\n" +
            "WHERE\n" +
            "    ff.createDate BETWEEN :startDate AND :endDate \n" +
            "\tAND ff.CampusId = :campusId\n" +
            "GROUP BY\n" +
            "    fp.FacilityProblemName", nativeQuery = true)
    @Modifying
    @Transactional
    List<Object[]> countProblem(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("campusId") int id);

}
