package com.mundia.Patient.web;


import com.mundia.Patient.dto.PatientReq;
import com.mundia.Patient.entities.Patient;
import com.mundia.Patient.services.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {
    final PatientServiceImpl patientService;
    //----------------------------------------------------
    @PostMapping("/add")
    public Patient addPatient(@RequestBody PatientReq patientReq) {
        return patientService.addPatient(patientReq);
    }
    //----------------------------------------------------
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }
    //--------------------------------------------------------
    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("/update/{id}")
    public Patient editPatient (@PathVariable Long id, @RequestBody PatientReq patientReq){
        if (id != null){
            return patientService.updatePatient(id, patientReq);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient (@PathVariable Long id){
        if(patientService.getPatientById(id) != null){
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}