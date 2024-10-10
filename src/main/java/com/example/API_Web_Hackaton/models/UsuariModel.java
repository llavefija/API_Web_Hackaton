package com.example.API_Web_Hackaton.models;

import jakarta.persistence.*;

// Classe que representa el model d'un usuari
@Entity
public class UsuariModel {

    // Identificador únic per a cada usuari
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generació automàtica del valor de l'id
    @Column(unique = true, nullable = false) // L'id ha de ser únic i no pot ser nul
    private Long id;

    // Nom de l'usuari
    @Column(nullable = false) // El nom no pot ser nul
    private String nom;

    // Correu electrònic de l'usuari
    @Column(nullable = false) // L'email no pot ser nul
    private String email;

    // Edat de l'usuari
    private int edad;

    // Getter per al nom
    public String getNom() {
        return nom;
    }

    // Setter per al nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter per al correu electrònic
    public String getEmail() {
        return email;
    }

    // Setter per al correu electrònic
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter per a l'edat
    public int getEdad() {
        return edad;
    }

    // Setter per a l'edat
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Getter per a l'id
    public Long getId() {
        return id;
    }

    // Setter per a l'id
    public void setId(Long id) {
        this.id = id;
    }
}
