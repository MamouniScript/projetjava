package com.mundia.Patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientReq {
    private String nom;
    private int age;
    private String adresse;
    private String contact;
}
