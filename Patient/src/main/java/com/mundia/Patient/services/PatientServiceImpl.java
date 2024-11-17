package com.mundia.Patient.services;

import com.mundia.Patient.dto.PatientDTO;
import com.mundia.Patient.dto.PatientReq;
import com.mundia.Patient.dto.PatientReq;
import com.mundia.Patient.entities.Patient;
import com.mundia.Patient.mappers.PatientMapper;
import com.mundia.Patient.repositories.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    final PatientRepo patientRepo;
    final PatientMapper patientMapper;
    final WebClient webClient;

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepo.findById(id);
        if(optionalPatient.isPresent()){
            return optionalPatient.get();
        }else {
            throw new EntityNotFoundException("Patient with id " + id + " not found");
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient addPatient(PatientReq patientReq) {
        Patient patient = patientMapper.fromPatientReq(patientReq);
        patientRepo.save(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(Long id, PatientReq patientReq) {
        Patient patient = getPatientById(id);
        patient.setNom(patientReq.getNom());
        patient.setAge(patientReq.getAge());
        patient.setAdresse(patientReq.getAdresse());
        patient.setContact(patientReq.getContact());
        patientRepo.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepo.delete(getPatientById(id));
    }

}