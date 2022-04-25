package com.cofomo.microservice.fournisseur.model;

import lombok.*;

import javax.persistence.*;

import static com.cofomo.microservice.fournisseur.utils.Constants.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = FOURNISSEUR, uniqueConstraints = {@UniqueConstraint(columnNames = {REFERENCE})})
public class FournisseurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = REFERENCE, unique = true)
    private String reference;

    @Column(name = COUNTRY, unique = true)
    private String country;

}
