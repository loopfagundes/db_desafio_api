package br.com.viacep.testcases;

import br.com.viacep.bases.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SeachZipCodeTestCase extends BaseTest {

    @Feature("GET - BUSCAR O CEP")
    @Test(
            description = "O metodo de buscar o cep.",
            priority = 1
    )
    public void seachZipCodeSuccessfully200() {
        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                    .log().all()
                .spec(seachZipCodeResponse);
    }
}