package com.imsc.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CentreVaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "centreVaccination", fetch = FetchType.EAGER)
    private List<Citoyen> citoyens;

    // Getter and setters

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Citoyen> getCitoyens() {
        return citoyens;
    }

    public void setCitoyens(List<Citoyen> citoyens) {
        this.citoyens = citoyens;
    }
}
