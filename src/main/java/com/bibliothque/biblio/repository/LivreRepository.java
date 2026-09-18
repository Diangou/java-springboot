package com.bibliothque.biblio.repository;

import com.bibliothque.biblio.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
}
