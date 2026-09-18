package com.bibliothque.biblio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    @ManyToOne
    @JoinColumn(name = "carte_id")
    Carte carte;
    // pas de relation JPA cote Livre -> non persiste pour l'instant
    @Transient
    private final List<Livre> livres;

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    protected Adherent() {
        this.livres = new ArrayList<>();
    }

    public Adherent(String nom, String prenom, List<Livre> livres, Carte carte) {
        this.nom = nom;
        this.prenom = prenom;
        this.livres = new ArrayList<>();
        this.carte = carte;
    }

    public Adherent(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.livres = new ArrayList<>();
    }

    public Livre emprunt(Livre livre) {
        livre.emprunter();
        this.livres.add(livre);
        return livre;
    }

    public Livre rendre(Livre livre) {
        livre.rendre();
        this.livres.remove(livre);
        return livre;
    }

    public void perdre(Livre livre) {
        if (livres.contains(livre)) {
            livres.remove(livre);
            livre.declarerPerdu();
        }
    }

    public void vol(Livre livre) {
        if (livres.contains(livre)) {
            livres.remove(livre);
            livre.vol();
        }
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Livre> getLivres() {
        return livres;
    }
}
