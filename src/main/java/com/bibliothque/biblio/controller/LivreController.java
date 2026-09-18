package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Livre;
import com.bibliothque.biblio.service.LivreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livre")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @PostMapping
    public Livre ajouterLivre(@RequestBody LivreRequest request) {
        return livreService.ajouter(request.titre(), request.auteurId());
    }

    @GetMapping
    public List<Livre> recupereLivre() {
        return livreService.recupereTousLesLivres();
    }

    @GetMapping("/{id}")
    public Livre recupereLivreParId(@PathVariable("id") int id) {
        return livreService.recupereLivreParId(id);
    }

    @DeleteMapping("/{id}")
    public Livre supprimerLivreParId(@PathVariable("id") int id) {
        return livreService.supprimerLivreParId(id);
    }

    @PutMapping("/{id}")
    public Livre modifierLivreParId(@PathVariable("id") int id, @RequestBody LivreRequest request) {
        return livreService.modifierLivreParId(id, request.titre());
    }
}
