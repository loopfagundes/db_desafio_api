package br.com.viacep.testcases.functionalTests;

import br.com.viacep.bases.zipCodeInvalidBaseTest;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class zipCodeInvalidTestCase extends zipCodeInvalidBaseTest {

    @Epic("Teste Funcional")
    @Feature("Teste o CEP invalido.")
    @Description("O metodo de buscar o cep inválido deve retornar 200.")
    @Test
    public void seachZipCodeInvalidSuccessfully200() throws IOException {
        given()
                    .spec(seachZipCodeInvalidRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                    .spec(seachZipCodeInvalidResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("schemas","validatorZipCodeInvalid.json")));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com numero falso.")
    @Description("O metodo de buscar o cep falso deve retornar 200")
    @Test
    public void seachZipCodeFaker200() throws IOException {
        given()
                    .spec(seachZipCodeFakerRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                    .spec(seachZipCodeFakerResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("schemas","validatorZipCodeFaker.json")));
    }
}