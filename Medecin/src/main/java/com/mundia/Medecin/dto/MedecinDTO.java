package com.mundia.Medecin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedecinDTO {
    private Long id;
    private String nom;
    private String specialite;
    private String contact;

}
