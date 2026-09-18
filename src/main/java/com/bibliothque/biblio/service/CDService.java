package com.bibliothque.biblio.service;

import com.bibliothque.biblio.model.CD;
import com.bibliothque.biblio.repository.CDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDService {

    private final CDRepository cdRepository;

    public CDService(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    public CD ajouter(String titre) {
        var cd = new CD(titre);
        return cdRepository.save(cd);
    }

    public List<CD> recupereTousLesCD() {
        return cdRepository.findAll();
    }

    public CD recupereCDParId(int id) {
        return cdRepository.findById(id).orElse(null);
    }

    public CD supprimerCDParId(int id) {
        CD cd = recupereCDParId(id);
        if (cd != null) {
            cdRepository.deleteById(id);
        }
        return cd;
    }

    public CD modifierCDParId(int id, String titre) {
        CD cd = recupereCDParId(id);
        if (cd != null) {
            cd.setTitre(titre);
            cdRepository.save(cd);
        }
        return cd;
    }
}
