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
    public Medecin getMedecinById(Long id) {
        Optional<Medecin> optionalMedecin = medecinRepo.findById(id);
        if(optionalMedecin.isPresent()){
            return optionalMedecin.get();
        }else {
            throw new EntityNotFoundException("Medecin with id " + id + " not found");
        }
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepo.findAll();
    }

    @Override
    public Medecin addMedecin(MedecinReq medecinReq) {
        Medecin medecin = medecinMapper.fromMedecinReq(medecinReq);
        medecinRepo.save(medecin);
        return medecin;
    }

    @Override
    public Medecin updateMedecin(Long id, MedecinReq medecinReq) {
        Medecin medecin = getMedecinById(id);
        medecin.setNom(medecinReq.getNom());
        medecin.setSpecialite(medecinReq.getSpecialite());
        medecin.setContact(medecinReq.getContact());
        medecinRepo.save(medecin);
        return medecin;
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepo.delete(getMedecinById(id));
    }

}