package com.cofomo.microservice.fournisseur.test.cucumber.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.hc.core5.http.HttpResponse;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FournisseurGetByReferenceDefs extends SpringIntegrationTest {

    String entreeFileName;
    HttpResponse response;

    @Given("on a un fournisseur {word}")
    public void givenWeHaveOneFournisseurGetByRef(String fileName) throws IOException, ParseException {
        entreeFileName = "entree/" + fileName;
        executePost(entreeFileName);
    }

    @When("l'utilisateur fait un appel GET ref = {word}")
    public void getRestApiTestGetByRef(String ref) throws IOException, ParseException {
        response = executeGetByReference(entreeFileName, ref);
    }

    @Then("le serveur gere l'appel du GET avec success {int}")
    public void the_client_receives_status_code_ofGetByRef(int code) {
        System.out.println("################## response = " + response);
        assertEquals(code, response.getCode());
    }

    /**
     *
     */

    @Given("on a un fournisseur en entree {word}")
    public void givenWeHaveOneFournisseurGetByRef2(String fileName) throws IOException, ParseException {
        entreeFileName = "entree/" + fileName;
        executePost(entreeFileName);
    }

    @When("l'utilisateur fait un appel GET avec reference non valide")
    public void getRestApiTestGetWhenGetByRef() throws IOException, ParseException {
        response = executeGetRefNotFound(entreeFileName, "errone");
    }

    @Then("le serveur gere l'appel GET avec Not_Found exception {int}")
    public void getRestApiTestGetThenGetByRef(int code) {
        assertEquals(code, response.getCode());
    }


}
