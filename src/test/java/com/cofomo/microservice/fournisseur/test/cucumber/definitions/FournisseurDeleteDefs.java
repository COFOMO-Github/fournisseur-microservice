package com.cofomo.microservice.fournisseur.test.cucumber.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.HttpResponse;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FournisseurDeleteDefs extends SpringIntegrationTest {

    HttpResponse response;
    HttpResponse response2;

    @Given("on a bien une fournisseur {word}")
    public void givenWeHaveOnefournisseur(String fileName) throws IOException, ParseException {
        executePost("entree/" + fileName);
    }

    @When("l'utilisateur fait un appel DELETE {int}")
    public void deleteRestApiTest(int code) throws IOException {
        response = executeDelete(code);
    }

    @Then("la fournisseur en question doit etre supprimée {int}")
    public void fournisseurShouldBeDeleted(int code) {
        assertEquals(code, response.getCode());
    }

    /**
     *
     */

    @When("l'utilisateur supprime une fournisseur non existante {int}")
    public void getRestApiTestGetNotFOundWhen(int code) throws IOException {
        response2 = executeDeleteNotFound(code);
    }

    @Then("une exception est generée {int}")
    public void getRestApiTestGetNotFOundThen(int code) {
        assertEquals(code, response2.getCode());
    }
}
