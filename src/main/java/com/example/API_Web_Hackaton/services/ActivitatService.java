package com.example.API_Web_Hackaton.services;


import com.example.API_Web_Hackaton.models.ActivitatModel;
import com.example.API_Web_Hackaton.repositories.ActivitatRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitatService {

    @Autowired
    ActivitatRepositori activitatRepositori;

    public ActivitatModel guardarActivitat(ActivitatModel activitat) {
        return activitatRepositori.save(activitat);
    }

    public List<ActivitatModel> obtenirActivitats() {
        return activitatRepositori.findAll();
    }

    public boolean inscriureActivitat(Long id) {
        ActivitatModel activitat = activitatRepositori.findById(id).orElse(null);
        if (activitat != null && activitat.getMax_cap() > 0) {
            activitat.setMax_cap(activitat.getMax_cap() - 1);
            activitatRepositori.save(activitat);
            return true;
        }
        return false;
    }

    public void importarActivitats(List<ActivitatModel> activitats) {
        activitatRepositori.saveAll(activitats);
    }
}
