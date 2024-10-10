package com.example.API_Web_Hackaton.services;

import com.example.API_Web_Hackaton.models.*;
import com.example.API_Web_Hackaton.repositories.UsuariRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

// Classe de servei per gestionar els usuaris
@Service
public class UsuariService {

    // Injecció de dependència del repositori d'usuaris
    @Autowired
    UsuariRepositori usuariRepositori;

    // Mètode per obtenir tots els usuaris
    public ArrayList<UsuariModel> obtenirUsuaris() {
        return (ArrayList<UsuariModel>) usuariRepositori.findAll();
    }

    // Mètode per guardar un nou usuari
    public UsuariModel guardarUsuari(UsuariModel usuari) {
        return usuariRepositori.save(usuari);
    }

    // Mètode per obtenir un usuari per ID
    public Optional<UsuariModel> obtenirUsuariID(Long id) {
        return usuariRepositori.findById(id);
    }

    // Mètode per actualitzar un usuari per ID
    public UsuariModel actualitzarUsuariID(Long id, UsuariModel detailsUsuari) {
        UsuariModel usuari = usuariRepositori.findById(id).orElse(null);
        // Comprova si l'usuari existeix
        if (usuari != null) {
            // Actualitza els detalls de l'usuari
            usuari.setNom(detailsUsuari.getNom());
            usuari.setEmail(detailsUsuari.getEmail());
            usuari.setEdad(detailsUsuari.getEdad());
            return usuariRepositori.save(usuari); // Guarda els canvis
        }
        return null; // Retorna null si l'usuari no existeix
    }

    // Mètode per eliminar un usuari per ID
    public boolean eliminarUsuari(Long id) {
        try {
            usuariRepositori.deleteById(id); // Intenta eliminar l'usuari
            return true; // Retorna true si l'eliminació ha estat exitosa
        } catch (Exception ex) {
            return false; // Retorna false si ha ocorregut un error
        }
    }
}
