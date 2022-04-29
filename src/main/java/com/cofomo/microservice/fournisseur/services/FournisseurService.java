package com.cofomo.microservice.fournisseur.services;



import com.cofomo.microservice.fournisseur.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    List<FournisseurDto> getFournisseurList();

    FournisseurDto getFournisseurById(Long id);

    FournisseurDto addFournisseur(FournisseurDto Fournisseur);

    void deleteFournisseur(Long id);

    FournisseurDto getFournisseurByReference(String productId);
}
