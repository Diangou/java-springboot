package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Artiste;
import com.bibliothque.biblio.service.ArtisteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Artiste", description = "Gestion des artistes")
@RestController
@RequestMapping("/api/artiste")
public class ArtisteController {

    private final ArtisteService artisteService;

    public ArtisteController(ArtisteService artisteService) {
        this.artisteService = artisteService;
    }

    @Operation(summary = "Creer un artiste")
    @PostMapping
    public Artiste ajouterArtiste(@RequestBody ArtisteRequest request) {
        return artisteService.ajouter(request.nom(), request.prenom());
    }

    @Operation(summary = "Lister les artistes")
    @GetMapping
    public List<Artiste> recupereArtiste() {
        return artisteService.recupereTousLesArtistes();
    }

    @Operation(summary = "Recuperer un artiste par son id")
    @GetMapping("/{id}")
    public Artiste recupereArtisteParId(@PathVariable("id") int id) {
        return artisteService.recupereArtisteParId(id);
    }

    @Operation(summary = "Supprimer un artiste par son id")
    @DeleteMapping("/{id}")
    public Artiste supprimerArtisteParId(@PathVariable("id") int id) {
        return artisteService.supprimerArtisteParId(id);
    }

    @Operation(summary = "Modifier le nom et prenom d'un artiste")
    @PutMapping("/{id}")
    public Artiste modifierArtisteParId(@PathVariable("id") int id, @RequestBody ArtisteRequest request) {
        return artisteService.modifierArtisteParId(id, request.nom(), request.prenom());
    }
}
