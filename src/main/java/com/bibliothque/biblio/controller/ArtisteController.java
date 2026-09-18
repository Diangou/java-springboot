package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Artiste;
import com.bibliothque.biblio.service.ArtisteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artiste")
public class ArtisteController {

    private final ArtisteService artisteService;

    public ArtisteController(ArtisteService artisteService) {
        this.artisteService = artisteService;
    }

    @PostMapping
    public Artiste ajouterArtiste(@RequestBody ArtisteRequest request) {
        return artisteService.ajouter(request.nom(), request.prenom());
    }

    @GetMapping
    public List<Artiste> recupereArtiste() {
        return artisteService.recupereTousLesArtistes();
    }

    @GetMapping("/{id}")
    public Artiste recupereArtisteParId(@PathVariable("id") int id) {
        return artisteService.recupereArtisteParId(id);
    }

    @DeleteMapping("/{id}")
    public Artiste supprimerArtisteParId(@PathVariable("id") int id) {
        return artisteService.supprimerArtisteParId(id);
    }

    @PutMapping("/{id}")
    public Artiste modifierArtisteParId(@PathVariable("id") int id, @RequestBody ArtisteRequest request) {
        return artisteService.modifierArtisteParId(id, request.nom(), request.prenom());
    }
}
