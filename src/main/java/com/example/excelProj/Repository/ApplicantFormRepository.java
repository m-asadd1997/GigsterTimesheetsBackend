package com.example.excelProj.Repository;

import com.example.excelProj.Model.ApplicantForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ApplicantForm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApplicantFormRepository extends JpaRepository<ApplicantForm, Long> {

}
