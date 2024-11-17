package com.mundia.Medecin.web;

import com.mundia.Medecin.dto.MedecinDTO;
import com.mundia.Medecin.dto.MedecinDTO;
import com.mundia.Medecin.dto.MedecinReq;
import com.mundia.Medecin.entities.Medecin;
import com.mundia.Medecin.services.MedecinService;
import com.mundia.Medecin.services.MedecinServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin")
@RequiredArgsConstructor
public class MedecinController {
    final MedecinServiceImpl medecinService;
    //----------------------------------------------------
    @PostMapping("/add")
    public Medecin addMedecin(@RequestBody MedecinReq medecinReq) {
        return medecinService.addMedecin(medecinReq);
    }
    //----------------------------------------------------
    @GetMapping("/{id}")
    public Medecin getMedecin(@PathVariable Long id) {
        return medecinService.getMedecinById(id);
    }
    //--------------------------------------------------------
    @GetMapping("/medecins")
    public List<Medecin> getMedecins() {
        return medecinService.getAllMedecins();
    }

    @PostMapping("/update/{id}")
    public Medecin editMedecin (@PathVariable Long id, @RequestBody MedecinReq medecinReq){
        if (id != null){
            return medecinService.updateMedecin(id, medecinReq);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedecin (@PathVariable Long id){
        if(medecinService.getMedecinById(id) != null){
            medecinService.deleteMedecin(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
