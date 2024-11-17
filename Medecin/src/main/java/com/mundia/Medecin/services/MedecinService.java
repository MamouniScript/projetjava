package com.mundia.Medecin.services;

import com.mundia.Medecin.dto.MedecinReq;
import com.mundia.Medecin.entities.Medecin;

import java.util.List;

public interface MedecinService {
    Medecin getMedecin(Long id);
    List<Medecin> getAllMedecins();
    List<Medecin> getMedecinByName(String nom);
    Medecin addMedecin(MedecinReq medecin);
    Medecin updateMedecin(Long id, MedecinReq medecin);
    void deleteMedecin(Long id);

}
