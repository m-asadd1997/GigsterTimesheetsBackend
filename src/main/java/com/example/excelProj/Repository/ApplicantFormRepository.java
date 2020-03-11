package com.example.excelProj.Repository;

import com.example.excelProj.Model.ApplicantForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ApplicantForm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApplicantFormRepository extends JpaRepository<ApplicantForm, Long> {

    @Query(value = "select * from applicant_form where check_email=:checkEmail",nativeQuery = true)
    public ApplicantForm getApplicantFormByEmail(@Param("checkEmail") String checkEmail);
}
