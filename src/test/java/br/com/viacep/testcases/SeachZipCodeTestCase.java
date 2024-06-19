package br.com.viacep.testcases;

import br.com.viacep.bases.SeachZipCodeBaseTest;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SeachZipCodeTestCase extends SeachZipCodeBaseTest {

    @Feature("GET - BUSCAR O CEP")
    @Test(
            description = "O metodo de buscar o cep.",
            priority = 1
    )
    public void seachZipCodeSuccessfully200() throws IOException {

        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                    .log().all()
                    .spec(seachZipCodeResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("validatorZipCodeSchema.json")));
    }
}