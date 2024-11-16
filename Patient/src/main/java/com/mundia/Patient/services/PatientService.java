package com.mundia.Patient.services;


import com.mundia.Patient.dto.PatientReq;
import com.mundia.Patient.entities.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient addPatient(PatientReq patientReq);
    Patient updatePatient(Long id, PatientReq patientReq);
    void deletePatient(Long id);



}
