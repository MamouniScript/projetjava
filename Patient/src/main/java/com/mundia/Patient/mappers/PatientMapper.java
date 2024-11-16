package com.mundia.Patient.mappers;

import com.mundia.Patient.dto.PatientReq;
import com.mundia.Patient.entities.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {
    public Patient fromPatientReq(PatientReq PatientReq) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(PatientReq, patient);
        return patient;
    }
}
