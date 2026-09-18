package com.bibliothque.biblio.service;

import com.bibliothque.biblio.model.Artiste;
import com.bibliothque.biblio.repository.ArtisteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteService {

    private final ArtisteRepository artisteRepository;

    public ArtisteService(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    public Artiste ajouter(String nom, String prenom) {
        var artiste = new Artiste(nom, prenom);
        return artisteRepository.save(artiste);
    }

    public List<Artiste> recupereTousLesArtistes() {
        return artisteRepository.findAll();
    }

    public Artiste recupereArtisteParId(int id) {
        return artisteRepository.findById(id).orElse(null);
    }

    public Artiste supprimerArtisteParId(int id) {
        Artiste artiste = recupereArtisteParId(id);
        if (artiste != null) {
            artisteRepository.deleteById(id);
        }
        return artiste;
    }

    public Artiste modifierArtisteParId(int id, String nom, String prenom) {
        Artiste artiste = recupereArtisteParId(id);
        if (artiste != null) {
            artiste.setNom(nom);
            artiste.setPrenom(prenom);
            artisteRepository.save(artiste);
        }
        return artiste;
    }
}
