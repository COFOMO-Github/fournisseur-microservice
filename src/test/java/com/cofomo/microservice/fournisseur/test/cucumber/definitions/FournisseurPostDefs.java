package com.cofomo.microservice.fournisseur.test.cucumber.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.HttpResponse;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FournisseurPostDefs extends SpringIntegrationTest {


    HttpResponse response;

    @When("l'utilisateur fait un appel POST {word}")
    public void theClientCallsPOSTFournisseur(String fileName) throws IOException, ParseException {
        response = executePost("entree/" + fileName);
    }

    @Then("le serveur gere l'appel POST avec success {int}")
    public void the_client_receives_status_code_of(int code) throws IOException, ParseException {
        assertEquals(code, response.getCode());
    }
}

