package com.mundia.rendezvous.services;

import com.mundia.rendezvous.dto.RendezVousReq;
import com.mundia.rendezvous.entities.RendezVous;
import com.mundia.rendezvous.mappers.RendezVousMapper;
import com.mundia.rendezvous.repositories.RendezVousRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RendezVousServiceImpl implements RendezVousService {
    final RendezVousRepo rendezVousRepo;
    final RendezVousMapper rendezVousMapper;
    final WebClient webClient;

    @Override
    public RendezVous getRendezVousById(Long id) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepo.findById(id);
        if(optionalRendezVous.isPresent()){
            return optionalRendezVous.get();
        }else {
            throw new EntityNotFoundException("RendezVous with id " + id + " not found");
        }
    }

    @Override
    public List<RendezVous> getAllRendezVouss() {
        return rendezVousRepo.findAll();
    }

    @Override
    public RendezVous addRendezVous(RendezVousReq rendezVousReq) {
        RendezVous rendezVous = rendezVousMapper.fromRendezVousReq(rendezVousReq);
        rendezVousRepo.save(rendezVous);
        return rendezVous;
    }

    @Override
    public RendezVous updateRendezVous(Long id, RendezVousReq rendezVousReq) {
        RendezVous rendezVous = getRendezVousById(id);
        rendezVous.setId_medecin(rendezVousReq.getId_medecin().getId());
        rendezVous.setId_patient(rendezVousReq.getId_patient().getId());
        rendezVous.setDate(rendezVousReq.getDate());
        rendezVous.setHeure(rendezVousReq.getHeure());
        rendezVousRepo.save(rendezVous);
        return rendezVous;
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepo.delete(getRendezVousById(id));
    }

}