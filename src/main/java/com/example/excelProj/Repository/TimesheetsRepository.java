package com.example.excelProj.Repository;

import com.example.excelProj.Model.Timesheets;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TimesheetsRepository extends JpaRepository<Timesheets,Long> {

    @Query(value = "select * from timesheets where organization_name=:organizationName",nativeQuery = true)
    public List<Timesheets> getByOrganizationName(@Param("organizationName") String organizationName);

    @Query(value ="select * from timesheets where user_id=:id",nativeQuery = true)
    public List<Timesheets> getTimeSheetsForLoggedinEmployee(@Param("id") Long id);

    @Query(value ="select * from timesheets where supervisor_id=:id and send_flag='YES'",nativeQuery = true)
    public List<Timesheets> getTimeSheetsForLoggedinSupervisor(@Param("id") Long id);

    @Query(value ="select * from timesheets where week_id =:id and user_id=:userId",nativeQuery = true)
    public Timesheets getTimesheetsByWeekId(@Param("id") Long id,@Param("userId") Long userId);
}
