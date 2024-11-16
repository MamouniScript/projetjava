package com.mundia.rendezvous.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
