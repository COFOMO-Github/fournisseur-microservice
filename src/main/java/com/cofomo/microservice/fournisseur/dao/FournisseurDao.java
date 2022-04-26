package com.cofomo.microservice.fournisseur.dao;

import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FournisseurDao extends JpaRepository<FournisseurEntity, Long> {
    Optional<FournisseurEntity> findByReference(String reference);
}
