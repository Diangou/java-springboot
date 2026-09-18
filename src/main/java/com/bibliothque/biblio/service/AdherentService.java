package com.bibliothque.biblio.service;

import com.bibliothque.biblio.enums.EtatCarte;
import com.bibliothque.biblio.model.Adherent;
import com.bibliothque.biblio.model.Carte;
import com.bibliothque.biblio.repository.AdherentRepository;
import com.bibliothque.biblio.repository.CarteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdherentService {

    private final AdherentRepository adherentRepository;
    private final CarteRepository carteRepository;

    public AdherentService(AdherentRepository adherentRepository, CarteRepository carteRepository) {
        this.adherentRepository = adherentRepository;
        this.carteRepository = carteRepository;
    }

    public Adherent ajouter(String nom, String prenom, String numeroCarte) {
        var adherent = new Adherent(nom, prenom);
        if (numeroCarte != null && !numeroCarte.isBlank()) {
            var carte = carteRepository.save(new Carte(numeroCarte));
            adherent.setCarte(carte);
        }
        return adherentRepository.save(adherent);
    }

    public List<Adherent> recupereTousLesAdherents() {
        return adherentRepository.findAll();
    }

    public Adherent recupereAdherentParId(int id) {
        return adherentRepository.findById(id).orElse(null);
    }

    public Adherent supprimerAdherentParId(int id) {
        Adherent adherent = recupereAdherentParId(id);
        if (adherent != null) {
            adherentRepository.deleteById(id);
        }
        return adherent;
    }

    public Adherent modifierAdherentParId(int id, String nom, String prenom) {
        Adherent adherent = recupereAdherentParId(id);
        if (adherent != null) {
            adherent.setNom(nom);
            adherent.setPrenom(prenom);
            adherentRepository.save(adherent);
        }
        return adherent;
    }

    public Adherent perteCarteAdherent(int id){
        Adherent adherent = recupereAdherentParId(id);
        adherent.getCarte().setEtat(EtatCarte.INACTIF);
        adherentRepository.save(adherent);
        return adherent;
    }
}
