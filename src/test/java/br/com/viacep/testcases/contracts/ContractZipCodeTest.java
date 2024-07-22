package br.com.viacep.testcases.contracts;

import br.com.viacep.bases.zipCodeValidBaseTest;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class ContractZipCodeTest extends zipCodeValidBaseTest {

    @Epic("Teste de contrato")
    @Feature("Teste o cep valido")
    @Description("Teste de contrato deve retornar 200 e valido se as chaves estão presentes no JSON resposta.")
    @Test
    public void validZipCodeSuccessfully200() throws IOException {
        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchema(ExpectedJson.json("contracts", "zipCode.json")))
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

    @Epic("Teste de contrato")
    @Feature("Teste o cep valido")
    @Description("O teste de contrato deve retornar 200 e valido se os valores das chaves estiverem corretos no JSON resposta.")
    @Test
    public void equalsZipCodeSuccessfully200() throws IOException {
        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                .spec(seachZipCodeResponse)
                    .body(JsonSchemaValidator.matchesJsonSchema(ExpectedJson.json("contracts", "zipCode.json")))
                    .body("$", hasKey("cep")).body("cep", equalTo("90619-900"))
                    .body("$", hasKey("logradouro")).body("logradouro", equalTo("Avenida Ipiranga"))
                    .body("$", hasKey("complemento")).body("complemento", equalTo("6681"))
                    .body("$", hasKey("unidade")).body("unidade", equalTo("Pontifícia Universidade Católica do Rio Grande do Sul"))
                    .body("$", hasKey("bairro")).body("bairro", equalTo("Partenon"))
                    .body("$", hasKey("localidade")).body("localidade", equalTo("Porto Alegre"))
                    .body("$", hasKey("uf")).body("uf", equalTo("RS"))
                    .body("$", hasKey("ibge")).body("ibge", equalTo("4314902"))
                    .body("$", hasKey("gia")).body("gia", equalTo(""))
                    .body("$", hasKey("ddd")).body("ddd", equalTo("51"))
                    .body("$", hasKey("siafi")).body("siafi", equalTo("8801"));
    }

    @Epic("Teste de contrato")
    @Feature("Teste o cep valido")
    @Description("Teste de contrato deve retornar 200 e valido se o CEP formatação.")
    @Test
    public void validFormattingZipCodeSuccessfully200() throws IOException {
        given()
                    .spec(zipCodeFormatRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchema(ExpectedJson.json("contracts", "zipCode.json")))
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