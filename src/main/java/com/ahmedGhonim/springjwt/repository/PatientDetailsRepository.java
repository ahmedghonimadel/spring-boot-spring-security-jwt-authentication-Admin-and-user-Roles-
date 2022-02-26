package com.ahmedGhonim.springjwt.repository;


import com.ahmedGhonim.springjwt.models.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Ghonim
 */
@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails,Long> {

    @Query(value = "UPDATE PatientDetails p set p.active= false where p.id = :id")
    @Modifying
    void delete(@Param("id")Long id);

    @Query(value = "select p from PatientDetails p where p.fullPatientName= :fullPatientName")
    List<PatientDetails> findByFullPatientName(@Param("fullPatientName") String fullPatientName);

}
