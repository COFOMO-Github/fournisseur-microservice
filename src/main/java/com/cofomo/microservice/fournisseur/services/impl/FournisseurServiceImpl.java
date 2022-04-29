package com.cofomo.microservice.fournisseur.services.impl;


import com.cofomo.microservice.fournisseur.dao.FournisseurDao;
import com.cofomo.microservice.fournisseur.dto.FournisseurDto;
import com.cofomo.microservice.fournisseur.mapper.MapStructMapper;
import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import com.cofomo.microservice.fournisseur.services.FournisseurService;
import com.cofomo.microservice.fournisseur.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurDao fournisseurDao;
    public final MapStructMapper mapper;

    @Override
    public List<FournisseurDto> getFournisseurList() {
        log.info("Service : Envoi de la liste completes des Fournisseurs");
        return mapper.FournisseurListEntityToFournisseurDtoList(fournisseurDao.findAll());
    }

    @Override
    public FournisseurDto getFournisseurById(Long id) {
        log.info("Service : Envoi du Fournisseur dont l'ID est : " + id);
        FournisseurEntity FournisseurEntity = fournisseurDao.findById(id).orElseThrow(()
                -> new NotFoundException(FournisseurEntity.class, id));
        return mapper.FournisseurEntityToFournisseurDto(FournisseurEntity);
    }

    @Override
    public FournisseurDto addFournisseur(FournisseurDto Fournisseur) {
        log.info("Service : Ajout d'une nouvelle Fournisseur  : " + Fournisseur.toString());
        FournisseurEntity FournisseurEntity = mapper.FournisseurDtoToFournisseurEntity(Fournisseur);
        return mapper.FournisseurEntityToFournisseurDto(fournisseurDao.save(FournisseurEntity));
    }

    @Override
    public void deleteFournisseur(Long id) {
        log.info("Service : Suppression du Fournisseur dont l'ID est : " + id);
        getFournisseurById(id);
        fournisseurDao.deleteById(id);
    }

    @Override
    public FournisseurDto getFournisseurByReference(String reference) {
        log.info("Service :  Envoi du Fournisseur qui contient le product dont l'ID est : " + reference);
        FournisseurEntity FournisseurEntity = fournisseurDao.findByReference(reference).orElseThrow(()
                -> new NotFoundException("No Supplier found with reference = " + reference));
        return mapper.FournisseurEntityToFournisseurDto(FournisseurEntity);
    }
}
