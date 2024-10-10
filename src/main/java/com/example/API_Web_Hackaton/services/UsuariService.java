package com.example.API_Web_Hackaton.services;

import com.example.API_Web_Hackaton.models.*;
import com.example.API_Web_Hackaton.repositories.UsuariRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuariService {
    @Autowired
    UsuariRepositori usuariRepositori;

    public ArrayList<UsuariModel> obtenirUsuaris(){
        return (ArrayList<UsuariModel>) usuariRepositori.findAll();
    }

    public UsuariModel guardarUsuari(UsuariModel usuari){
        return usuariRepositori.save(usuari);
    }

    public Optional<UsuariModel> obtenirUsuariID(Long id){
        return usuariRepositori.findById(id);
    }

    public UsuariModel actualitzarUsuariID(Long id, UsuariModel detailsUsuari) {
        UsuariModel usuari = usuariRepositori.findById(id).orElse(null);
        if (usuari != null) {
            usuari.setNom(detailsUsuari.getNom());
            usuari.setEmail(detailsUsuari.getEmail());
            usuari.setEdad(detailsUsuari.getEdad());
            return usuariRepositori.save(usuari);
        }
        return null;
    }

    public boolean eliminarUsuari(Long id){
        try {
            usuariRepositori.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
