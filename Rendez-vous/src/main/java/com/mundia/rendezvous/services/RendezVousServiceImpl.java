package com.mundia.rendezvous.services;

import com.mundia.rendezvous.dto.RendezVousReq;
import com.mundia.rendezvous.entities.RendezVous;
import com.mundia.rendezvous.mappers.RendezVousMapper;
import com.mundia.rendezvous.repositories.RendezVousRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousServiceImpl implements RendezVousService {

    final RendezVousRepo rendezVousRepo;
    final RendezVousMapper rendezVousMapper;
    final WebClient webClient;

    @Override
    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> rendezVous = rendezVousRepo.findAll();
        return rendezVous;
    }

    @Override
    public List<RendezVous> findByMedecin(Long idMedecin) {
        List<RendezVous> rendezVous = rendezVousRepo.findByMedecin(idMedecin);
        return rendezVous;
    }

    @Override
    public List<RendezVous> findByPatient(Long idPatient) {
        List<RendezVous> rendezVous = rendezVousRepo.findByPatient(idPatient);
        return rendezVous;
    }

    @Override
    public List<RendezVous> findByDate(Date date) {
        List<RendezVous> rendezVous = rendezVousRepo.findByDate(date);
        return rendezVous;
    }

    @Override
    public List<RendezVous> findByTime(Time time) {
        List<RendezVous> rendezVous = rendezVousRepo.findByTime(time);
        return rendezVous;
    }

    @Override
    public RendezVous addRendezVous(RendezVousReq rendezVousReq) {
        return
    }
}
