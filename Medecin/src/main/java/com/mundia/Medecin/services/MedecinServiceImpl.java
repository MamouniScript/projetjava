package com.mundia.Medecin.services;

import com.mundia.Medecin.dto.MedecinDTO;
import com.mundia.Medecin.dto.MedecinReq;
import com.mundia.Medecin.entities.Medecin;
import com.mundia.Medecin.mappers.MedecinMapper;
import com.mundia.Medecin.repositories.MedecinRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedecinServiceImpl implements MedecinService {
    final MedecinRepo medecinRepo;
    final MedecinMapper medecinMapper;
    final WebClient webClient;

    @Override
    public Medecin getMedecin(Long id) {
        Optional<Medecin> optionalMedecin= medecinRepo.findById(id);
        if(optionalMedecin.isPresent()){
            return optionalMedecin.get();
        }else {
            throw new EntityNotFoundException("Medecin n'existe pas!");
        }
    }

    @Override
    public List<Medecin> getAllMedecins() {
        List<Medecin> medecins = medecinRepo.findAll();
        return medecins;
    }
    @Override
    public List<Medecin> getMedecinByName(String nom) {
        List<Medecin> medecins = medecinRepo.findAllByNom(nom);
        return medecins;
    }

    @Override
    public Medecin addMedecin(MedecinReq Medecin) {
        Medecin medecin1 = medecinMapper.fromMedecinReq(Medecin);
        medecinRepo.save(medecin1);
        return medecin1;
    }

    @Override
    public Medecin updateMedecin(Long id, MedecinReq medecinReq) {
        if (getMedecin(id) != null){
            Medecin medecin = getMedecin(id);
            medecin.setNom(medecinReq.getNom());
            medecin.setSpecialite(medecinReq.getSpecialite());
            medecin.setContact(medecinReq.getContact());
            return medecin;
        }
        return null;
    }

    @Override
    public void deleteMedecin(Long id) {
        if (getMedecin(id) != null){
            medecinRepo.delete(getMedecin(id));
        }
    }


}
