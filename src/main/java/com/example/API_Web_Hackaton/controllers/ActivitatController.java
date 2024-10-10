package com.example.API_Web_Hackaton.controllers;


import com.example.API_Web_Hackaton.services.ActivitatService;
import com.example.API_Web_Hackaton.models.ActivitatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appActivitats")
public class ActivitatController {

    @Autowired
    ActivitatService activitatService;

    // Crear una nova activitat
    @PostMapping("/activitat")
    public ActivitatModel guardarActivitat(@RequestBody ActivitatModel activitat) {
        return activitatService.guardarActivitat(activitat);
    }

    // Obtenir totes les activitats
    @GetMapping("/activitats")
    public List<ActivitatModel> obtenirActivitats() {
        return activitatService.obtenirActivitats();
    }

    // Inscriu un usuari a una activitat
    @PostMapping("/activitats/{id}/join")
    public String apuntarActivitat(@PathVariable Long id) {
        boolean ok = activitatService.inscriureActivitat(id);
        if (ok) {
            return "Inscrit amb èxit.";
        } else {
            return "No hi ha espai disponible a l'activitat.";
        }
    }

    // Exportar activitats desde un JSON
    @GetMapping("/export")
    public List<ActivitatModel> exportarActivitats() {
        return activitatService.obtenirActivitats();  // Cambiar por el código para exportar a JSON si es necesario
    }

    // Importar activitats desde un arxiu JSON
    @PostMapping("/import")
    public String importarActivitats(@RequestBody List<ActivitatModel> activitats) {
        activitatService.importarActivitats(activitats);
        return "Activitats importades correctament.";
    }
}

