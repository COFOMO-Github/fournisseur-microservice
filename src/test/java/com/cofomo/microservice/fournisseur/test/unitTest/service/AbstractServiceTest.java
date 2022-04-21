package com.cofomo.microservice.fournisseur.test.unitTest.service;


import com.cofomo.microservice.fournisseur.dao.FournisseurDao;
import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import com.cofomo.microservice.fournisseur.services.FournisseurService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractServiceTest {

    @Autowired
    protected FournisseurDao fournisseurDao;
    @Autowired
    protected FournisseurService fournisseurService;

    protected static final Long NOT_EXISTING_ID = 99999L;

    protected FournisseurEntity fournisseur1 = new FournisseurEntity();
    protected FournisseurEntity fournisseur2 = new FournisseurEntity();
    protected FournisseurEntity fournisseur3 = new FournisseurEntity();

    @BeforeEach
    public void init() {
        fournisseur1 = fournisseurDao.save(fournisseur1());
        fournisseur2 = fournisseurDao.save(fournisseur2());
        fournisseur3 = fournisseurDao.save(fournisseur3());
    }

    @AfterEach
    public void clean() {
        fournisseurDao.deleteAll();
    }


    public FournisseurEntity fournisseur1() {
        return FournisseurEntity.builder()
                .id(null)
                .name("Iphone 11 PRO MAX")
                .price(7000D)
                .build();
    }

    public FournisseurEntity fournisseur2() {
        FournisseurEntity entity = new FournisseurEntity();
        entity.setId(null);
        entity.setName("IphoneX");
        entity.setPrice(4000D);
        return entity;
    }

    public FournisseurEntity fournisseur3() {
        return FournisseurEntity.builder()
                .id(null)
                .name("Iphone 13")
                .price(12000D)
                .build();
    }


}
