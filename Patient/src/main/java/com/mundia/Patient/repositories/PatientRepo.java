package com.mundia.Patient.repositories;

import com.mundia.Patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PatientRepo extends JpaRepository<Patient, Long> {

}
