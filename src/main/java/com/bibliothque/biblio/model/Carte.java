package com.bibliothque.biblio.model;

import com.bibliothque.biblio.biblioInterface.Article;
import com.bibliothque.biblio.enums.EtatArticle;
import com.bibliothque.biblio.enums.EtatCarte;
import jakarta.persistence.*;

@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numeroSerie;
    @ManyToOne
    @JoinColumn(name = "adherent_id")
    Adherent adherent;
    EtatCarte etat = EtatCarte.ACTIF;

    protected Carte() {}

    public Carte(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public void setEtat(EtatCarte etat){
        this.etat = etat;
    }

    public EtatCarte getEtat() {
        return this.etat;
    }

    public void perdu() {
        setEtat(EtatCarte.INACTIF);
    }
}
