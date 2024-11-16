package com.mundia.Medecin.repositories;

import com.mundia.Medecin.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {
    List<Medecin> findAllByNom(String nom);


}
