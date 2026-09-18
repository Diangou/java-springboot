package com.bibliothque.biblio.model;

import com.bibliothque.biblio.biblioInterface.Article;
import com.bibliothque.biblio.enums.EtatArticle;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CD implements Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String genre;
    @ManyToOne
    private Artiste artiste;
    @Enumerated(EnumType.STRING)
    private EtatArticle etat = EtatArticle.LIBRE;
    private int annee;
    @ManyToOne
    private Etagere etagere;

    protected CD() {
    }

    public CD(String titre, String genre, Artiste artiste, int annee, Etagere etagere) {
        this.titre = titre;
        this.genre = genre;
        this.artiste = artiste;
        this.annee = annee;
        this.etagere = etagere;
    }

    public CD(String titre, Artiste artiste, String genre, int annee) {
        this.titre = titre;
        this.artiste = artiste;
        this.genre = genre;
        this.annee = annee;
        this.etagere = null;
    }

    public CD(String titre) {
        this.titre = titre;
        this.genre = null;
        this.artiste = null;
        this.annee = 0;
        this.etagere = null;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public EtatArticle getEtat() {
        return etat;
    }

    public int getAnnee() {
        return annee;
    }

    public Etagere getEtagere() {
        return etagere;
    }

    @Override
    public void emprunter() {
        this.etat = EtatArticle.EMPRUNTE;
    }

    @Override
    public void vol() {
        this.etat = EtatArticle.VOL;
    }

    @Override
    public void declarerPerdu() {
        this.etat = EtatArticle.PERDU;
    }

    @Override
    public void rendre() {
        this.etat = EtatArticle.LIBRE;
    }

    @Override
    public void detruit() {
        this.etat = EtatArticle.DETRUIT;
    }
}
