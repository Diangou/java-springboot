package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Livre;
import com.bibliothque.biblio.service.LivreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Livre", description = "Gestion des livres")
@RestController
@RequestMapping("/api/livre")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @Operation(summary = "Creer un livre")
    @PostMapping
    public Livre ajouterLivre(@RequestBody LivreRequest request) {
        return livreService.ajouter(request.titre(), request.auteurId());
    }

    @Operation(summary = "Lister les livres")
    @GetMapping
    public List<Livre> recupereLivre() {
        return livreService.recupereTousLesLivres();
    }

    @Operation(summary = "Recuperer un livre par son id")
    @GetMapping("/{id}")
    public Livre recupereLivreParId(@PathVariable("id") int id) {
        return livreService.recupereLivreParId(id);
    }

    @Operation(summary = "Supprimer un livre par son id")
    @DeleteMapping("/{id}")
    public Livre supprimerLivreParId(@PathVariable("id") int id) {
        return livreService.supprimerLivreParId(id);
    }

    @Operation(summary = "Modifier le titre d'un livre")
    @PutMapping("/{id}")
    public Livre modifierLivreParId(@PathVariable("id") int id, @RequestBody LivreRequest request) {
        return livreService.modifierLivreParId(id, request.titre());
    }
}
