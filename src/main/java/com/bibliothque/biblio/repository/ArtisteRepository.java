package com.bibliothque.biblio.repository;

import com.bibliothque.biblio.model.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {
}
