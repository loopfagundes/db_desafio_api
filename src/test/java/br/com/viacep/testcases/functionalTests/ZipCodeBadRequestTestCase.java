package br.com.viacep.testcases.functionalTests;

import br.com.viacep.bases.zipCodeBadRequestBaseTest;
import br.com.viacep.utils.ZipCodeProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ZipCodeBadRequestTestCase extends zipCodeBadRequestBaseTest {

    @Epic("Teste Funcional")
    @Feature("Teste o CEP vazio.")
    @Description("O método de busca do CEP vazio deve retornar o status 400.")
    @Test
    public void emptyZipCodeSearchBadRequest400() {
        given()
                    .spec(zipCodeEmptyRequest)
                .when()
                    .get()
                .then()
                    .spec(statusBadRequest)
                    .body(Matchers.containsString("Http 400"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP invalido.")
    @Description("O método de busca do CEP invalido deve retornar o status 400.")
    @Test(dataProvider = "zipCodeInvalidProvider", dataProviderClass = ZipCodeProvider.class)
    public void invalidZipCodeSearchBadRequest400(String zipCodeInvalid) {
        given()
                    .spec(baseUrl)
                .when()
                    .get(zipCodeInvalid + "/json")
                .then()
                .spec(statusBadRequest)
                    .body(Matchers.containsString("Http 400"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com endereço e logradouro nao existe.")
    @Description("O método de busca do CEP com endereço e logradouro não existe deve retornar o status 400.")
    @Test
    public void searchForZipCodeWithAddressAndStreetDoesNotExistBadRequest400() {
        given()
                    .spec(zipCodePublicAreaNotExisteRequest)
                .when()
                    .get()
                .then()
                    .spec(statusBadRequest)
                    .body(Matchers.containsString("Http 400"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com endereço e cidade nao existe.")
    @Description("O método de busca do CEP com endereço com cidade não existe deve retornar o status 400.")
    @Test
    public void searchForZipCodeWithAddressAndCityDoesNotExistBadRequest400() {
        given()
                    .spec(zipCodeCityNotExisteRequest)
                .when()
                    .get()
                .then()
                    .spec(statusBadRequest)
                    .body(Matchers.containsString("Http 400"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com endereço e UF nao existe.")
    @Description("O método de busca do CEP com endereço com UF não existe deve retornar o status 400.")
    @Test
    public void searchForZipCodeWithAddressAndUFDoesNotExistBadRequest400() {
        given()
                    .spec(zipCodeUFNotExistRequest)
                .when()
                    .get()
                .then()
                    .spec(statusBadRequest)
                    .body(Matchers.containsString("Http 400"));
    }
}