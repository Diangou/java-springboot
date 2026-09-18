package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Auteur;
import com.bibliothque.biblio.service.AuteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auteur")
public class AuteurController {

    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @PostMapping
    public Auteur ajouterAuteur(@RequestBody AuteurRequest request) {
        return auteurService.ajouter(request.nom(), request.prenom());
    }

    @GetMapping
    public List<Auteur> recupereAuteur() {
        return auteurService.recupereTousLesAuteurs();
    }

    @GetMapping("/{id}")
    public Auteur recupereAuteurParId(@PathVariable("id") int id) {
        return auteurService.recupereAuteurParId(id);
    }

    @DeleteMapping("/{id}")
    public Auteur supprimerAuteurParId(@PathVariable("id") int id) {
        return auteurService.supprimerAuteurParId(id);
    }

    @PutMapping("/{id}")
    public Auteur modifierAuteurParId(@PathVariable("id") int id, @RequestBody AuteurRequest request) {
        return auteurService.modifierAuteurParId(id, request.nom(), request.prenom());
    }
}
