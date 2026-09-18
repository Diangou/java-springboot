package com.bibliothque.biblio.controller;

import com.bibliothque.biblio.model.CD;
import com.bibliothque.biblio.service.CDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cd")
public class CDController {

    private final CDService cdService;

    public CDController(CDService cdService) {
        this.cdService = cdService;
    }

    @PostMapping
    public CD ajouterCD(@RequestBody CDRequest request) {
        return cdService.ajouter(request.titre());
    }

    @GetMapping
    public List<CD> recupereCD() {
        return cdService.recupereTousLesCD();
    }

    @GetMapping("/{id}")
    public CD recupereCDParId(@PathVariable("id") int id) {
        return cdService.recupereCDParId(id);
    }

    @DeleteMapping("/{id}")
    public CD supprimerCDParId(@PathVariable("id") int id) {
        return cdService.supprimerCDParId(id);
    }

    @PutMapping("/{id}")
    public CD modifierCDParId(@PathVariable("id") int id, @RequestBody CDRequest request) {
        return cdService.modifierCDParId(id, request.titre());
    }
}
