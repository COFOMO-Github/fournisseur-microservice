package com.cofomo.microservice.fournisseur.test.unitTest.controller;


import com.cofomo.microservice.fournisseur.dao.error.RestError;
import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import com.cofomo.microservice.fournisseur.web.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.cofomo.microservice.fournisseur.utils.Constants.FOURNISSEUR_URL;
import static com.cofomo.microservice.fournisseur.web.exception.FunctionalErrorCode.NOT_FOUND_ENTITY_ID;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ControllerTest extends AbstractControllerTest {

    @BeforeEach
    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getFournisseurList() throws Exception {
        String uri = FOURNISSEUR_URL + "/list";

        when(fournisseurService.getFournisseurList()).thenReturn(fournisseurDtoList());

        this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void getFournisseurById() throws Exception {
        Long id = 1L;
        String uri = FOURNISSEUR_URL + "/" + id;
        when(fournisseurService.getFournisseurById(id)).thenReturn(fournisseurDto1());

        this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getFournisseurByIdShouldThrowNotFound() throws Exception {
        Long id = 9999L;
        String uri = FOURNISSEUR_URL + "/" + id;
        when(fournisseurService.getFournisseurById(id)).thenThrow(new NotFoundException(FournisseurEntity.class, id));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound()).andReturn();
        assertEquals(NOT_FOUND_ENTITY_ID.getHttpStatus().value(), mvcResult.getResponse().getStatus());
        RestError error = super.mapFromJson(mvcResult.getResponse().getContentAsString(), RestError.class);
        assertEquals(String.format(NOT_FOUND_ENTITY_ID.getMessageTemplate(), FournisseurEntity.class.getSimpleName(), id), error.getMessage());
    }

    @Test
    public void deleteFournisseurTest() throws Exception {
        Long id = 1L;
        String uri = FOURNISSEUR_URL + "/delete/" + id;
        when(fournisseurService.getFournisseurById(id)).thenReturn(fournisseurDto1());
        this.mockMvc.perform(MockMvcRequestBuilders.delete(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void addFournisseurTest() throws Exception {
        String uri = FOURNISSEUR_URL+"/";
        String expectedString = super.mapToJson(fournisseur2());
        when(fournisseurService.addFournisseur(fournisseurDto1())).thenReturn(fournisseurDto1());
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(expectedString))
                .andExpect(status().isCreated()).andDo(print());
    }
}
