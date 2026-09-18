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
public class Livre implements Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String genre;
    @Enumerated(EnumType.STRING)
    private EtatArticle etat = EtatArticle.LIBRE;
    @ManyToOne
    private Auteur auteur;
    @ManyToOne
    private Etagere etagere;
    private String edition;

    protected Livre() {
    }

    public Livre(String titre, String genre, boolean libre, Auteur auteur, Etagere etagere, String edition)  {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.etagere = etagere;
        this.edition = edition;

    }

    public Livre(String titre, Auteur auteur, String genre, String edition) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.etagere = null;
        this.edition = edition;
    }

    public Livre(String titre) {
        this.titre = titre;
        this.genre = null;
        this.auteur = null;
        this.etagere = null;
        this.edition = null;
    }

    public int getId() {
        return id;
    }

    public int deleteId() {
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

    public EtatArticle getEtat() {
        return etat;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public Etagere getEtagere() {
        return etagere;
    }

    public void setEtagere(Etagere etagere) {
        this.etagere = etagere;
    }

    public String getEdition() {
        return edition;
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


























