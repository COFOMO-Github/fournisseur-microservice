package com.cofomo.microservice.fournisseur.test.cucumber;

import com.cofomo.microservice.fournisseur.test.cucumber.definitions.SpringIntegrationTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.cofomo.microservice.fournisseur", features = "src/test/resources/cucumber/features")
public class CucumberTest extends SpringIntegrationTest {


}
