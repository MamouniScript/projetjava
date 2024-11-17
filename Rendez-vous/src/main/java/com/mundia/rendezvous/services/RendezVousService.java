package com.mundia.rendezvous.services;

import com.mundia.rendezvous.dto.RendezVousReq;
import com.mundia.rendezvous.entities.RendezVous;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface RendezVousService {
    RendezVous getRendezVousById(Long id);
    List<RendezVous> getAllRendezVouss();
    RendezVous addRendezVous(RendezVousReq rendezVousReq);
    RendezVous updateRendezVous(Long id, RendezVousReq rendezVousReq);
    void deleteRendezVous(Long id);

}
