package br.com.viacep.testcases.functionalTests;

import br.com.viacep.bases.ZipCodeValidBaseTest;
import br.com.viacep.dto.CepDto;
import br.com.viacep.stubs.CepStub;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class ZipCodeValidTestCase extends ZipCodeValidBaseTest {

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com valido schema JSON.")
    @Description("O método de busca do CEP deve retornar o status 200.")
    @Test
    public void searchZipCodeSuccessfully200() {
        given()
                    .spec(searchZipCodeRequest)
                .when()
                    .get()
                .then()
                    .spec(statusOK)
                    .assertThat().body(matchesJsonSchemaInClasspath("schemas/schemaZipCodeValid.json"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com endereço e valido schema JSON.")
    @Description("O metodo de buscar o CEP com endereço deve retornar o status 200.")
    @Test
    public void searchZipCodeWithAddressSuccessfully200() {
        given()
                    .spec(searchZipCodeWithAddressRequest)
                .when()
                    .get()
                .then()
                    .spec(statusOK).log().all()
                    .body("cep[0]", equalTo("91010-000"))
                    .body("logradouro[0]", equalTo("Avenida Assis Brasil"))
                    .body("localidade[0]", equalTo("Porto Alegre"))
                    .body("uf[0]", equalTo("RS"))
                    .assertThat().body(matchesJsonSchemaInClasspath("schemas/schemaZipCodeAddress.json"));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com Stub.")
    @Description("O método de buscar o CEP com Stub deve retornar o status 200.")
    @Test
    public void assertValidZipCodeWithStubSuccessfully200() {
        CepDto response = given()
                    .spec(searchZipCodeRequest)
                .when()
                    .get()
                .then()
                    .spec(statusOK)
                    .extract().as(CepDto.class);
        assertEquals(response.getCep(), CepStub.getCepStub().getCep());
        assertEquals(response.getLogradouro(), CepStub.getCepStub().getLogradouro());
        assertEquals(response.getComplemento(), CepStub.getCepStub().getComplemento());
        assertEquals(response.getUnidade(), CepStub.getCepStub().getUnidade());
        assertEquals(response.getBairro(), CepStub.getCepStub().getBairro());
        assertEquals(response.getLocalidade(), CepStub.getCepStub().getLocalidade());
        assertEquals(response.getUf(), CepStub.getCepStub().getUf());
        assertEquals(response.getIbge(), CepStub.getCepStub().getIbge());
        assertEquals(response.getGia(), CepStub.getCepStub().getGia());
        assertEquals(response.getDdd(), CepStub.getCepStub().getDdd());
        assertEquals(response.getSiafi(), CepStub.getCepStub().getSiafi());
    }
}