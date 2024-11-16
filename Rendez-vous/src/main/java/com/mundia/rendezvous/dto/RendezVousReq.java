package com.mundia.rendezvous.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RendezVousReq {
    private PatientDTO id_patient;
    private MedecinDTO id_medecin;
    @Column(name = "date")
    private Date date;
    @Column(name = "heure")
    private Time heure;
}
