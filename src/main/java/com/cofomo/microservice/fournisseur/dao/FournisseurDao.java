package com.cofomo.microservice.fournisseur.dao;

import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FournisseurDao extends JpaRepository<FournisseurEntity, Long> {
    FournisseurEntity findByReference(String reference);
}
