package com.bibliothque.biblio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;

    protected Auteur() {
    }

    public Auteur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

    }

    public Auteur(String nom, String prenom) {
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

    private Livre ecrire(String titre, String genre, String edition){
        return new Livre(titre, this, genre, edition);
    }

}
