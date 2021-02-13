package com.example.excelProj.Repository;


import com.example.excelProj.Model.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface ClientDataRepository extends JpaRepository <ClientData, Long> {

    List<ClientData> findByActivityStatus(String activityStatus);
}
