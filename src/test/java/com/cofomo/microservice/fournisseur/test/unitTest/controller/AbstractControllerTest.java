package com.cofomo.microservice.fournisseur.test.unitTest.controller;


import com.cofomo.microservice.fournisseur.dto.FournisseurDto;
import com.cofomo.microservice.fournisseur.mapper.MapStructMapper;
import com.cofomo.microservice.fournisseur.model.FournisseurEntity;
import com.cofomo.microservice.fournisseur.services.FournisseurService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@WebAppConfiguration
public abstract class AbstractControllerTest {

    protected static String BASE_URL;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @MockBean
    protected FournisseurService fournisseurService;

    @Autowired
    protected MapStructMapper mapStructMapper;

    protected MockMvc mockMvc;


    @Value("${server.port}")
    protected void getBaseUrl(String port) {
        BASE_URL = "http://localhost:" + port + "/api/v1/fournisseur";
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        module.addDeserializer(LocalDateTime.class, deserializer);
        objectMapper.registerModule(module);
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        module.addDeserializer(LocalDateTime.class, deserializer);
        objectMapper.registerModule(module);
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        return objectMapper.readValue(json, clazz);
    }


    public FournisseurEntity fournisseur1() {
        return FournisseurEntity.builder()
                .name("Apple")
                .reference("")
                .build();
    }

    public FournisseurDto fournisseurDto1() {
        return FournisseurDto.builder()
                .name("Apple")
                .reference("3L")
                .build();
    }

    public FournisseurEntity fournisseur2() {
        return FournisseurEntity.builder()
                .name("Apple")
                .reference("2L")
                .build();
    }

    public FournisseurEntity fournisseur3() {
        return FournisseurEntity.builder()
                .name("Apple")
                .reference("4L")
                .build();
    }

    public List<FournisseurDto> fournisseurDtoList() {
        return new ImmutableList.Builder<FournisseurEntity>()
                .add(fournisseur1())
                .add(fournisseur2())
                .add(fournisseur3()).build().stream().map(fournisseurEntity ->
                        mapStructMapper.FournisseurEntityToFournisseurDto(fournisseurEntity)).collect(Collectors.toList());
    }
}
