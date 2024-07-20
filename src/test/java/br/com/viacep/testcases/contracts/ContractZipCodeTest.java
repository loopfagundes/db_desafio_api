package br.com.viacep.testcases.contracts;

import br.com.viacep.bases.SeachZipCodeBaseTest;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.Feature;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class ContractZipCodeTest extends SeachZipCodeBaseTest {

    @Feature("TESTE DE CONTRATO")
    @Test(
            description = "Teste de CEP valido deve retronar 200.",
            groups = {"TESTE DE CONTRATO"}
    )
    public void seachZipCodeValid200() throws IOException {
        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then().spec(status_SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchema(ExpectedJson.json("contracts", "zipCodeValidate.json")))
                    .body("$", hasKey("cep"))
                    .body("$", hasKey("logradouro"))
                    .body("$", hasKey("complemento"))
                    .body("$", hasKey("unidade"))
                    .body("$", hasKey("bairro"))
                    .body("$", hasKey("localidade"))
                    .body("$", hasKey("uf"))
                    .body("$", hasKey("ibge"))
                    .body("$", hasKey("gia"))
                    .body("$", hasKey("ddd"))
                    .body("$", hasKey("siafi"));
    }
}