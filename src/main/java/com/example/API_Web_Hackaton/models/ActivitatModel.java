package com.example.API_Web_Hackaton.models;

import jakarta.persistence.*;

// Classe que representa el model d'una activitat
@Entity
public class ActivitatModel {

    // Identificador únic per a cada activitat
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generació automàtica del valor de l'id
    @Column(unique = true, nullable = false) // L'id ha de ser únic i no pot ser nul
    private Long id;

    // Nom de l'activitat
    @Column(nullable = false) // El nom no pot ser nul
    private String nom;

    // Descripció de l'activitat
    private String descripcio;

    // Capacitat màxima de participants en l'activitat
    private int max_cap;

    // Getter per a l'id
    public Long getId() {
        return id;
    }

    // Setter per a l'id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter per al nom
    public String getNom() {
        return nom;
    }

    // Setter per al nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter per a la descripció
    public String getDescripcio() {
        return descripcio;
    }

    // Setter per a la descripció
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    // Getter per a la capacitat màxima
    public int getMax_cap() {
        return max_cap;
    }

    // Setter per a la capacitat màxima
    public void setMax_cap(int max_cap) {
        this.max_cap = max_cap;
    }
}
