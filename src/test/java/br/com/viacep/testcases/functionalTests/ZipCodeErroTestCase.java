package br.com.viacep.testcases.functionalTests;

import br.com.viacep.bases.zipCodeErroBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ZipCodeErroTestCase extends zipCodeErroBaseTest {

    @Epic("Teste Funcional")
    @Feature("Teste o CEP erro.")
    @Description("O metodo de buscar o CEP erro deve retornar 200.")
    @Test
    public void seachZipCodeErro200() {
        given()
                    .spec(seachZipCodeErroRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                    .spec(statusOK)
                    .body(Matchers.containsString("\"erro\": \"true\""))
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/schemaZipCodeErro.json"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com numero falso.")
    @Description("O metodo de buscar o CEP com numero falso deve retornar 200")
    @Test
    public void seachZipCodeFaker200() {
        given()
                    .spec(seachZipCodeFakerRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                    .spec(statusOK)
                    .body(Matchers.containsString("\"erro\": \"true\""))
                    .assertThat().body(matchesJsonSchemaInClasspath("schemas/schemaZipCodeFaker.json"));
    }
}