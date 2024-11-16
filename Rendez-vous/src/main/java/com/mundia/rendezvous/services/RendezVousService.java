package com.mundia.rendezvous.services;

import com.mundia.rendezvous.dto.RendezVousReq;
import com.mundia.rendezvous.entities.RendezVous;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface RendezVousService {

    List<RendezVous> getAllRendezVous();
    List<RendezVous> findByMedecin(Long idMedecin);
    List<RendezVous> findByPatient(Long idPatient);
    List<RendezVous> findByDate(Date date);
    List<RendezVous> findByTime(Time time);
    RendezVous addRendezVous(RendezVousReq rendezVousReq);

}
