package com.bibliothque.biblio.service;

import com.bibliothque.biblio.model.Auteur;
import com.bibliothque.biblio.model.Livre;
import com.bibliothque.biblio.repository.AuteurRepository;
import com.bibliothque.biblio.repository.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    private final LivreRepository livreRepository;
    private final AuteurRepository auteurRepository;

    public LivreService(LivreRepository livreRepository, AuteurRepository auteurRepository) {
        this.livreRepository = livreRepository;
        this.auteurRepository = auteurRepository;
    }

    public Livre ajouter(String titre, Integer auteurId) {
        Livre livre;
        if (auteurId != null) {
            Auteur auteur = auteurRepository.findById(auteurId).orElse(null);
            livre = new Livre(titre, auteur, null, null);
        } else {
            livre = new Livre(titre);
        }
        return livreRepository.save(livre);
    }

    public List<Livre> recupereTousLesLivres() {
        return livreRepository.findAll();
    }

    public Livre recupereLivreParId(int id) {
        return livreRepository.findById(id).orElse(null);
    }

    public Livre supprimerLivreParId(int id) {
        Livre livre = recupereLivreParId(id);
        if (livre != null) {
            livreRepository.deleteById(id);
        }
        return livre;
    }

    public Livre modifierLivreParId(int id, String titre) {
        Livre livre = recupereLivreParId(id);
        if (livre != null) {
            livre.setTitre(titre);
            livreRepository.save(livre);
        }
        return livre;
    }

}
