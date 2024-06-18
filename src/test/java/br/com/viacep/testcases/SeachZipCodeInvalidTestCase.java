package br.com.viacep.testcases;

import br.com.viacep.bases.SeachZipCodeInvalidBaseTest;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SeachZipCodeInvalidTestCase extends SeachZipCodeInvalidBaseTest {

    @Feature("GET - BUSCAR O CEP INVÁLIDO")
    @Test(
            description = "O metodo de buscar o cep inválido.",
            priority = 2
    )
    public void seachZipCodeInvalidSuccessfully200() throws IOException {

        given()
                    .spec(seachZipCodeInvalidRequest)
                .when()
                    .get()
                .then()
                    .log().all()
                    .spec(seachZipCodeInvalidResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("validatorZipCodeInvalidSchema.json")));
    }
}