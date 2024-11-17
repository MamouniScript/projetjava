package com.mundia.rendezvous.repositories;

import com.mundia.rendezvous.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findAll();

    List<RendezVous> findByDate(Date date);


    List<RendezVous> findByHeure(Time time);


}
