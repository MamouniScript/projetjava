package com.mundia.Medecin.services;

import com.mundia.Medecin.dto.MedecinReq;
import com.mundia.Medecin.entities.Medecin;

import java.util.List;

public interface MedecinService {
    Medecin getMedecinById(Long id);
    List<Medecin> getAllMedecins();
    Medecin addMedecin(MedecinReq medecinReq);
    Medecin updateMedecin(Long id, MedecinReq medecinReq);
    void deleteMedecin(Long id);

}
