package com.cofomo.microservice.fournisseur.mapper;

import com.cofomo.microservice.fournisseur.dto.FournisseurDto;
import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import io.swagger.model.Fournisseur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {


    Fournisseur FournisseurDtoToFournisseur(FournisseurDto Fournisseur);

    FournisseurDto FournisseurToFournisseurDto(Fournisseur Fournisseur);

    FournisseurEntity FournisseurDtoToFournisseurEntity(FournisseurDto Fournisseur);

    FournisseurDto FournisseurEntityToFournisseurDto(FournisseurEntity Fournisseur);


    List<Fournisseur> FournisseurListDtoToFournisseurList(List<FournisseurDto> Fournisseur);

    List<FournisseurDto> FournisseurListToFournisseurDtoList(List<Fournisseur> Fournisseur);


    List<FournisseurEntity> FournisseurListDtoToFournisseurEntityList(List<FournisseurDto> Fournisseur);

    List<FournisseurDto> FournisseurListEntityToFournisseurDtoList(List<FournisseurEntity> Fournisseur);

}
