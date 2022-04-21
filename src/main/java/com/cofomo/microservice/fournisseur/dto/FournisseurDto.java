package com.cofomo.microservice.fournisseur.dto;

import lombok.*;

import javax.persistence.Id;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDto {

    @Id
    private Long id;

    private String name;

    private String matricule;

    private String reference;


}
