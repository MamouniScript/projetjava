package com.mundia.rendezvous.web;

import com.mundia.rendezvous.dto.RendezVousReq;
import com.mundia.rendezvous.entities.RendezVous;
import com.mundia.rendezvous.services.RendezVousService;
import com.mundia.rendezvous.services.RendezVousServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rendezVous")
@RequiredArgsConstructor
public class RendezVousController {
    final RendezVousServiceImpl rendezVousService;
    //----------------------------------------------------
    @PostMapping("/add")
    public RendezVous addRendezVous(@RequestBody RendezVousReq rendezVousReq) {
        return rendezVousService.addRendezVous(rendezVousReq);
    }
    //----------------------------------------------------
    @GetMapping("/{id}")
    public RendezVous getRendezVous(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id);
    }
    //--------------------------------------------------------
    @GetMapping("/rendezVouss")
    public List<RendezVous> getRendezVouss() {
        return rendezVousService.getAllRendezVouss();
    }

    @PostMapping("/update/{id}")
    public RendezVous editRendezVous (@PathVariable Long id, @RequestBody RendezVousReq rendezVousReq){
        if (id != null){
            return rendezVousService.updateRendezVous(id, rendezVousReq);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRendezVous (@PathVariable Long id){
        if(rendezVousService.getRendezVousById(id) != null){
            rendezVousService.deleteRendezVous(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
