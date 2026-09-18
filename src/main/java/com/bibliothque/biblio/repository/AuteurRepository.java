package com.bibliothque.biblio.repository;

import com.bibliothque.biblio.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
}
