package com.mundia.Medecin.web;

import com.mundia.Medecin.dto.MedecinDTO;
import com.mundia.Medecin.dto.MedecinDTO;
import com.mundia.Medecin.dto.MedecinReq;
import com.mundia.Medecin.entities.Medecin;
import com.mundia.Medecin.services.MedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin")
@RequiredArgsConstructor
public class MedecinController {
    final MedecinService medecinService;
    //----------add--------------------------------------
    @PostMapping("/add")
    public Medecin addMedecin(@RequestBody MedecinReq medecin) {
       return medecinService.addMedecin(medecin);
    }
    //--------------1 Medecin--------------
    @GetMapping("/{nom}")
    public Medecin getMedecinByName(@PathVariable String nom) {
        List<Medecin> medecins = medecinService.getMedecinByName(nom);
        return medecins.get(0);
    }
    //-----------list----------------------------------
    @GetMapping("/medecins")
    public List<Medecin> getMedecins() {
        return medecinService.getAllMedecins();
    }


}
