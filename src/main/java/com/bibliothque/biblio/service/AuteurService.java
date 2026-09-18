package com.bibliothque.biblio.service;

import com.bibliothque.biblio.model.Auteur;
import com.bibliothque.biblio.repository.AuteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {

    private final AuteurRepository auteurRepository;

    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public Auteur ajouter(String nom, String prenom) {
        var auteur = new Auteur(nom, prenom);
        return auteurRepository.save(auteur);
    }

    public List<Auteur> recupereTousLesAuteurs() {
        return auteurRepository.findAll();
    }

    public Auteur recupereAuteurParId(int id) {
        return auteurRepository.findById(id).orElse(null);
    }

    public Auteur supprimerAuteurParId(int id) {
        Auteur auteur = recupereAuteurParId(id);
        if (auteur != null) {
            auteurRepository.deleteById(id);
        }
        return auteur;
    }

    public Auteur modifierAuteurParId(int id, String nom, String prenom) {
        Auteur auteur = recupereAuteurParId(id);
        if (auteur != null) {
            auteur.setNom(nom);
            auteur.setPrenom(prenom);
            auteurRepository.save(auteur);
        }
        return auteur;
    }
}
