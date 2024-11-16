package com.mundia.rendezvous.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PatientDTO {
    private Long id;
    private String nom;
    private int age;
    private String adresse;
    private String contact;
}
