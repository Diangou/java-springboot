package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.CD;
import com.bibliothque.biblio.service.CDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CD", description = "Gestion des CD")
@RestController
@RequestMapping("/api/cd")
public class CDController {

    private final CDService cdService;

    public CDController(CDService cdService) {
        this.cdService = cdService;
    }

    @Operation(summary = "Creer un CD")
    @PostMapping
    public CD ajouterCD(@RequestBody CDRequest request) {
        return cdService.ajouter(request.titre());
    }

    @Operation(summary = "Lister les CD")
    @GetMapping
    public List<CD> recupereCD() {
        return cdService.recupereTousLesCD();
    }

    @Operation(summary = "Recuperer un CD par son id")
    @GetMapping("/{id}")
    public CD recupereCDParId(@PathVariable("id") int id) {
        return cdService.recupereCDParId(id);
    }

    @Operation(summary = "Supprimer un CD par son id")
    @DeleteMapping("/{id}")
    public CD supprimerCDParId(@PathVariable("id") int id) {
        return cdService.supprimerCDParId(id);
    }

    @Operation(summary = "Modifier le titre d'un CD")
    @PutMapping("/{id}")
    public CD modifierCDParId(@PathVariable("id") int id, @RequestBody CDRequest request) {
        return cdService.modifierCDParId(id, request.titre());
    }
}
