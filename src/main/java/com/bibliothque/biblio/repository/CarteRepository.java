package com.bibliothque.biblio.repository;

import com.bibliothque.biblio.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, Integer> {
}
