package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Auteur;
import com.bibliothque.biblio.service.AuteurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Auteur", description = "Gestion des auteurs")
@RestController
@RequestMapping("/api/auteur")
public class AuteurController {

    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @Operation(summary = "Creer un auteur")
    @PostMapping
    public Auteur ajouterAuteur(@RequestBody AuteurRequest request) {
        return auteurService.ajouter(request.nom(), request.prenom());
    }

    @Operation(summary = "Lister les auteurs")
    @GetMapping
    public List<Auteur> recupereAuteur() {
        return auteurService.recupereTousLesAuteurs();
    }

    @Operation(summary = "Recuperer un auteur par son id")
    @GetMapping("/{id}")
    public Auteur recupereAuteurParId(@PathVariable("id") int id) {
        return auteurService.recupereAuteurParId(id);
    }

    @Operation(summary = "Supprimer un auteur par son id")
    @DeleteMapping("/{id}")
    public Auteur supprimerAuteurParId(@PathVariable("id") int id) {
        return auteurService.supprimerAuteurParId(id);
    }

    @Operation(summary = "Modifier le nom et prenom d'un auteur")
    @PutMapping("/{id}")
    public Auteur modifierAuteurParId(@PathVariable("id") int id, @RequestBody AuteurRequest request) {
        return auteurService.modifierAuteurParId(id, request.nom(), request.prenom());
    }
}
