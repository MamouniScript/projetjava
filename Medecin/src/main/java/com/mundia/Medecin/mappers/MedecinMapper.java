package com.mundia.Medecin.mappers;

import com.mundia.Medecin.dto.MedecinReq;
import com.mundia.Medecin.entities.Medecin;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MedecinMapper {

    public Medecin fromMedecinReq(MedecinReq medecinReq){
        Medecin medecin = new Medecin();
        BeanUtils.copyProperties(medecinReq, medecin);
        return medecin;
    }
}
