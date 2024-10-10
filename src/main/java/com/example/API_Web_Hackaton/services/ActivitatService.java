package com.example.API_Web_Hackaton.services;

import com.example.API_Web_Hackaton.models.ActivitatModel;
import com.example.API_Web_Hackaton.repositories.ActivitatRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Classe de servei per gestionar les activitats
@Service
public class ActivitatService {

    // Injecció de dependència del repositori d'activitats
    @Autowired
    ActivitatRepositori activitatRepositori;

    // Mètode per guardar una nova activitat
    public ActivitatModel guardarActivitat(ActivitatModel activitat) {
        return activitatRepositori.save(activitat);
    }

    // Mètode per obtenir totes les activitats
    public List<ActivitatModel> obtenirActivitats() {
        return activitatRepositori.findAll();
    }

    // Mètode per inscriure un usuari a una activitat
    public boolean inscriureActivitat(Long id) {
        ActivitatModel activitat = activitatRepositori.findById(id).orElse(null);
        // Comprova si l'activitat existeix i si hi ha places disponibles
        if (activitat != null && activitat.getMax_cap() > 0) {
            // Redueix el màxim de capacitat en 1
            activitat.setMax_cap(activitat.getMax_cap() - 1);
            activitatRepositori.save(activitat);
            return true;
        }
        return false; // Retorna false si no s'ha pogut inscriure
    }

    // Mètode per importar una llista d'activitats
    public void importarActivitats(List<ActivitatModel> activitats) {
        activitatRepositori.saveAll(activitats);
    }
}
