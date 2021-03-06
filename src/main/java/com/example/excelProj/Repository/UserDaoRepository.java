package com.example.excelProj.Repository;

import com.example.excelProj.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface UserDaoRepository extends JpaRepository<User, Long> {

    User findByEmail(String username);

    @Query(value = "select * from user where active=true",nativeQuery = true)
    public List<User> findByActive();

    public User findByEmailAndActive(String email,Boolean active);

    public User findByEmailAndUserType(String email,String userType);

    @Query(value = "select * from user where user_type='SUPERVISOR' and organization_name=:organizationName",nativeQuery = true)
    public List<User> getSupervisorsByOrganizationName(@Param("organizationName") String organizationName);

    @Query(value = "select * from user where organization_name=:organizationName and (user_type='employee' or user_type = 'supervisor')",nativeQuery = true)
    public List<User> getUsersByOrganizationName(@Param("organizationName") String organizationName);

    @Query(value ="select * from user where organization_name=:organizationName and user_type = 'admin'",nativeQuery = true)
    public User getAdminOfOrganization(@Param("organizationName") String organizationName);

    Boolean existsByEmail(String username);
}
