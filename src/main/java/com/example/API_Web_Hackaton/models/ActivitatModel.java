package com.example.API_Web_Hackaton.models;


import jakarta.persistence.*;

@Entity
public class ActivitatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String descripcio;
    private int max_cap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getMax_cap() {
        return max_cap;
    }

    public void setMax_cap(int max_cap) {
        this.max_cap = max_cap;
    }

}
