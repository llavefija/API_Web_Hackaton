package com.example.API_Web_Hackaton.controllers;

import com.example.API_Web_Hackaton.services.ActivitatService;
import com.example.API_Web_Hackaton.models.ActivitatModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    // Exportar activitats a un arxiu JSON
    @GetMapping("/export")
    public ResponseEntity<String> exportarActivitats() {
        List<ActivitatModel> activitats = activitatService.obtenirActivitats();

        // Nom de l'arxiu JSON que es generarà
        String fileName = "activitats_exportades.json";
        File file = new File(fileName);

        // Escribir la lista de actividades en el archivo
        try (FileWriter fileWriter = new FileWriter(file)) {
            String json = new ObjectMapper().writeValueAsString(activitats); // Usar ObjectMapper de Jackson
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error en l'exportació", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Configurar les capçaleres de la resposta per a la descàrrega de l'arxiu
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .body("Exportació d'activitats realitzada amb èxit: " + fileName);
    }

    // Importar activitats des d'un arxiu JSON
    @PostMapping("/import")
    public String importarActivitats(@RequestBody List<ActivitatModel> activitats) {
        activitatService.importarActivitats(activitats);
        return "Activitats importades correctament.";
    }
}
