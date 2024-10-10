package com.example.API_Web_Hackaton.controllers;


import com.example.API_Web_Hackaton.models.UsuariModel;
import com.example.API_Web_Hackaton.services.UsuariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/appActivitats")
public class UsuariController {

    @Autowired
    UsuariService usuariService;

    // Registra un nou usuari
    @PostMapping("/user")
    public UsuariModel guardarUsuari(@RequestBody UsuariModel usuari){
        return usuariService.guardarUsuari(usuari);
    }

    // Obté tots els usuaris
    @GetMapping("/users")
    public ArrayList<UsuariModel> obtenirUsuaris(){
        return usuariService.obtenirUsuaris();
    }

    // Obte la informacio de un usuari especific per la ID
    @GetMapping("/users/{id}")
    public Optional<UsuariModel> obtenirUsuariID(@PathVariable("id") Long id){
        return usuariService.obtenirUsuariID(id);
    }

    // Actualitza la informacio de un usuari per la ID
    @PutMapping("/users/{id}")
    public UsuariModel actualitzarUsuariID(@PathVariable Long id, @RequestBody UsuariModel usuari){
        return usuariService.actualitzarUsuariID(id, usuari);
    }

    @DeleteMapping("/users/{id}")
    public String eliminarPerID(@PathVariable("id") Long id){
        boolean ok = usuariService.eliminarUsuari(id);
        if (ok){
            return "S'ha eliminat al usuari amb id " + id;
        }
        else{
            return "No s'ha eliminat al usuari amb id " + id;

        }
    }

}