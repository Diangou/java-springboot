package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Adherent;
import com.bibliothque.biblio.service.AdherentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Adherent", description = "Gestion des adherents et de leur carte")
@RestController
@RequestMapping("/api/adherent")
public class AdherentController {

    private final AdherentService adherentService;

    public AdherentController(AdherentService adherentService) {
        this.adherentService = adherentService;
    }

    @Operation(summary = "Creer un adherent", description = "Cree un adherent, avec une carte optionnelle si un numero de carte est fourni")
    @PostMapping
    public Adherent ajouterAdherent(@RequestBody AdherentRequest request) {
        return adherentService.ajouter(request.nom(), request.prenom(), request.carte());
    }

    @Operation(summary = "Lister les adherents")
    @GetMapping
    public List<Adherent> recupereAdherent() {
        return adherentService.recupereTousLesAdherents();
    }

    @Operation(summary = "Recuperer un adherent par son id")
    @GetMapping("/{id}")
    public Adherent recupereAdherentParId(@PathVariable("id") int id) {
        return adherentService.recupereAdherentParId(id);
    }

    @Operation(summary = "Supprimer un adherent par son id")
    @DeleteMapping("/{id}")
    public Adherent supprimerAdherentParId(@PathVariable("id") int id) {
        return adherentService.supprimerAdherentParId(id);
    }

    @Operation(summary = "Modifier le nom et prenom d'un adherent")
    @PutMapping("/{id}")
    public Adherent modifierAdherentParId(@PathVariable("id") int id, @RequestBody AdherentRequest request) {
        return adherentService.modifierAdherentParId(id, request.nom(), request.prenom());
    }
}
