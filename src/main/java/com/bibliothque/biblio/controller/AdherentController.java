package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.Adherent;
import com.bibliothque.biblio.service.AdherentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adherent")
public class AdherentController {

    private final AdherentService adherentService;

    public AdherentController(AdherentService adherentService) {
        this.adherentService = adherentService;
    }

    @PostMapping
    public Adherent ajouterAdherent(@RequestBody AdherentRequest request) {
        return adherentService.ajouter(request.nom(), request.prenom());
    }

    @GetMapping
    public List<Adherent> recupereAdherent() {
        return adherentService.recupereTousLesAdherents();
    }

    @GetMapping("/{id}")
    public Adherent recupereAdherentParId(@PathVariable("id") int id) {
        return adherentService.recupereAdherentParId(id);
    }

    @DeleteMapping("/{id}")
    public Adherent supprimerAdherentParId(@PathVariable("id") int id) {
        return adherentService.supprimerAdherentParId(id);
    }

    @PutMapping("/{id}")
    public Adherent modifierAdherentParId(@PathVariable("id") int id, @RequestBody AdherentRequest request) {
        return adherentService.modifierAdherentParId(id, request.nom(), request.prenom());
    }
}
