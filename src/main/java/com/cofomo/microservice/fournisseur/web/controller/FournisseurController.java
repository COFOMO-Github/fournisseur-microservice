package com.cofomo.microservice.fournisseur.web.controller;

import com.cofomo.microservice.fournisseur.dto.FournisseurDto;
import com.cofomo.microservice.fournisseur.mapper.MapStructMapper;
import com.cofomo.microservice.fournisseur.services.FournisseurService;
import io.swagger.api.FournisseurApi;
import io.swagger.model.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class FournisseurController implements FournisseurApi {

    FournisseurService fournisseurService;
    MapStructMapper mapper;

    @Override
    public ResponseEntity<Fournisseur> addFournisseur(Fournisseur Fournisseur) {
        log.info("Ajout d'une nouvelle Fournisseur : " + Fournisseur.toString());
        FournisseurDto FournisseurDto = mapper.FournisseurToFournisseurDto(Fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapper.FournisseurDtoToFournisseur(fournisseurService.addFournisseur(FournisseurDto))
        );
    }

    @Override
    public ResponseEntity<Boolean> deleteFournisseur(String id) {
        log.info("Suppression de la Fournisseur dont l'ID est : " + id);
        fournisseurService.deleteFournisseur(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Fournisseur> getFournisseur(String id) {
        log.info("Envoi du Fournisseur dont l'ID est : " + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.FournisseurDtoToFournisseur(fournisseurService.getFournisseurById(Long.parseLong(id))));
    }

    @Override
    public ResponseEntity<Fournisseur> getFournisseurByReference(String reference) {
        log.info("Envoi du Fournisseur par reference produit");
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.FournisseurDtoToFournisseur(fournisseurService.getFournisseurByReference(reference)));
    }

    @Override
    public ResponseEntity<List<Fournisseur>> getFournisseurs() {
        log.info("Envoi de la liste completes des Fournisseurs");
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.FournisseurListDtoToFournisseurList(fournisseurService.getFournisseurList()));
    }
}
