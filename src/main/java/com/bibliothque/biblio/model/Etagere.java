package com.bibliothque.biblio.model;

import com.bibliothque.biblio.enums.EtatArticle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
public class Etagere {
    private static final int MAX_LIVRE = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "row_num")
    private int row;
    private int col;
    @OneToMany(mappedBy = "etagere")
    private List<Livre> livres;

    protected Etagere() {
    }

    public Etagere(int row, int col, Livre...livres) {
        this.row = row;
        this.col = col;
        this.setLivres(Arrays.asList(livres));
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        if (livres.size() >= MAX_LIVRE) {
            throw new IllegalArgumentException("Il y a trop de livre taille max 10");
        }

        this.livres = new ArrayList<>(livres);
        this.livres.stream()
                .filter(livre -> livre.getTitre() != null)
                .forEach(livre -> livre.setEtagere(this));
    }

    public void addLivre(Livre livre) {
        this.livres.add(livre);
        livre.setEtagere(this);
    }

    void prendFeu() {
        livres.stream()
                .filter(livre -> livre.getEtat() == EtatArticle.LIBRE)
                .forEach(Livre::detruit);
    }
}
