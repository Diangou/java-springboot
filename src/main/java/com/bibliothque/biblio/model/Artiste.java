package com.bibliothque.biblio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;

    protected Artiste() {
    }

    public Artiste(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

    }

    public Artiste(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    @Override
    public String toString() {
        return "Id: " + id + " Nom: " + nom + " Prenom: " + prenom;
    }

    private CD produire(String titre, String genre, int annee) {return new CD(titre, this, genre, annee);}

}