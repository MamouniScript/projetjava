package com.mundia.rendezvous.mappers;


import com.mundia.rendezvous.dto.RendezVousReq;
import com.mundia.rendezvous.entities.RendezVous;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RendezVousMapper {
    public RendezVous fromRendezVousReq(RendezVousReq RendezVousReq) {
    RendezVous rendezVous = new RendezVous();
    BeanUtils.copyProperties(RendezVousReq, rendezVous);
    return rendezVous;
}
}
