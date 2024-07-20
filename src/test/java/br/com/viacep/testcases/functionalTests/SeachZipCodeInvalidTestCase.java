package br.com.viacep.testcases.functionalTests;

import br.com.viacep.bases.SeachZipCodeInvalidBaseTest;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SeachZipCodeInvalidTestCase extends SeachZipCodeInvalidBaseTest {

    @Feature("TESTE FUNCIONAL")
    @Test(
            description = "O metodo de buscar o cep inválido.",
            groups = {"TESTE FUNCIONAL"}
    )
    public void seachZipCodeInvalidSuccessfully200() throws IOException {
        given()
                    .spec(seachZipCodeInvalidRequest)
                .when()
                    .get()
                .then()
                    .log().all()
                    .spec(seachZipCodeInvalidResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("schemas","validatorZipCodeInvalid.json")));
    }

    @Feature("TESTE FUNCIONAL")
    @Test(
            description = "O metodo de buscar o cep falso.",
            groups = {"TESTE FUNCIONAL"}
    )
    public void seachZipCodeFaker200() throws IOException {
        given()
                    .spec(seachZipCodeFakerRequest)
                .when()
                    .get()
                .then()
                    .log().all()
                    .spec(seachZipCodeFakerResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("schemas","validatorZipCodeFaker.json")));
    }
}