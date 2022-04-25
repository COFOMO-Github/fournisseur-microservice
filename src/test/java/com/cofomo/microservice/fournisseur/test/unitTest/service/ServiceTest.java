package com.cofomo.microservice.fournisseur.test.unitTest.service;

import com.cofomo.microservice.fournisseur.dto.FournisseurDto;
import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import com.cofomo.microservice.fournisseur.web.exception.NotFoundException;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.cofomo.microservice.fournisseur.web.exception.FunctionalErrorCode.NOT_FOUND_ENTITY_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ServiceTest extends AbstractServiceTest {


    @Test
    public void getAllFournisseursTest() {
        //WHEN
        List<FournisseurDto> fournisseurs = fournisseurService.getFournisseurList();
        //THEN
        assertThat(fournisseurs).isNotNull().isNotEmpty();
    }

    @Test
    public void findFournisseurByIdTest() {
        //WHEN
        FournisseurDto output = fournisseurService.getFournisseurById(fournisseur2.getId());

        //THEN
        assertNotNull(output);
        assertEquals(fournisseur2.getName(), output.getName());
        assertEquals(fournisseur2.getId(), output.getId());
    }

    @Test
    public void findFournisseurByIdShouldThrowNotFoundExceptionTest() {
        //WHEN
        Throwable throwable = catchThrowable(() -> fournisseurService.getFournisseurById(NOT_EXISTING_ID));

        //THEN
        assertThat(throwable).isInstanceOf(NotFoundException.class);
    }

    @Test
    public void saveFournisseurTest() {
        //GIVEN
        FournisseurDto fournisseur = FournisseurDto.builder()
                .name("Samsung S20 Ultra")
                .build();

        //WHEN
        FournisseurDto output = fournisseurService.addFournisseur(fournisseur);

        //THEN
        assertNotNull(output);
        assertNotNull(output.getId());
        assertEquals(fournisseur.getName(), output.getName());
    }

    @Test
    public void deleteFournisseurTest() {
        //GIVEN
        assertNotNull(fournisseur2);
        assertNotNull(fournisseur2.getId());

        //WHEN
        fournisseurService.deleteFournisseur(fournisseur2.getId());
        Throwable throwable = catchThrowable(() -> fournisseurService.getFournisseurById(fournisseur2.getId()));

        //THEN
        assertThat(throwable).isInstanceOf(NotFoundException.class);
    }

    @Test
    public void deleteFournisseurShouldThrowNotFoundExceptionTest() {

        Throwable throwable = catchThrowable(() -> fournisseurService.deleteFournisseur(NOT_EXISTING_ID));
        assertThat(throwable).isInstanceOf(NotFoundException.class);
        assertEquals(throwable.getMessage(),
                String.format(NOT_FOUND_ENTITY_ID.getMessageTemplate(), FournisseurEntity.class.getSimpleName(), NOT_EXISTING_ID));
    }

    @Test
    public void testFournisseurEntityToString() {
        ToStringVerifier.forClass(FournisseurEntity.class)
                .withClassName(NameStyle.SIMPLE_NAME)
                .verify();
    }


    @Test
    public void testHashCode() {

        FournisseurEntity fournisseurEntity1 = fournisseur1;
        FournisseurEntity fournisseurEntity2 = fournisseur1;

        assertEquals(fournisseurEntity1, fournisseurEntity2);
        assertEquals(fournisseurEntity2, fournisseurEntity1);
        assertEquals(fournisseurEntity1.hashCode(), fournisseurEntity2.hashCode());
    }


//    @Test
//    public void canEqualTest() {
//
//        FournisseurEntity fournisseurEntity1 = fournisseur1;
//
//        FournisseurEntity.canEqual(fournisseurEntity1);
//
//    }


}
