package com.bibliothque.biblio.service;

import com.bibliothque.biblio.enums.EtatCarte;
import com.bibliothque.biblio.model.Carte;
import com.bibliothque.biblio.repository.CarteRepository;

import java.util.List;

public class CarteService {

    private final CarteRepository carteRepository;

    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public Carte ajouter(String numeroSerie) {
        var carte = new Carte(numeroSerie);
        return carteRepository.save(carte);
    }

    public List<Carte> recupereTousLesCarte() {
        return carteRepository.findAll();
    }

    public Carte recupereCarteParId(int id) {
        return carteRepository.findById(id).orElse(null);
    }

    public Carte supprimerCarteParId(int id) {
        Carte carte = recupereCarteParId(id);
        if (carte != null) {
            carteRepository.deleteById(id);
        }
        return carte;
    }

    public Carte carteInactif(int id) {
        Carte carte = recupereCarteParId(id);
        if (carte != null) {
            carte.setEtat(EtatCarte.INACTIF);
            carteRepository.save(carte);
        }
        return carte;
    }

    public Carte carteActif(int id) {
        Carte carte = recupereCarteParId(id);
        if (carte != null) {
            carte.setEtat(EtatCarte.ACTIF);
            carteRepository.save(carte);
        }
        return carte;
    }
}
