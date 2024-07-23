package br.com.viacep.testcases.functionalTests;

import br.com.viacep.bases.zipCodeValidBaseTest;
import br.com.viacep.dto.CepDto;
import br.com.viacep.stubs.CepStub;
import br.com.viacep.utils.ExpectedJson;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class zipCodeValidTestCase extends zipCodeValidBaseTest {

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com valido schema JSON.")
    @Description("O método de busca do CEP deve retornar o status 200.")
    @Test
    public void seachZipCodeSuccessfully200() throws IOException {
        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                    .spec(seachZipCodeResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("schemas", "schemaZipCode.json")));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com endereço e valido schema JSON.")
    @Description("O metodo de buscar o cep com endereço deve retornar o status 200.")
    @Test
    public void seachZipCodeWithAddressSuccessfully200() throws IOException {
        given()
                    .spec(seachZipCodeWithAddressRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                    .spec(seachZipCodeResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("schemas","schemaZipCodeAddress.json")));
    }

    @Epic("Teste Funcional")
    @Feature("Teste o CEP com Stub.")
    @Description("O método de buscar o CEP com Stub deve retornar o status 200.")
    @Test
    public void assertValidZipCodeWithStubSuccessfully200() {
        CepDto response = given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                .spec(seachZipCodeResponse)
                    .log().body()
                    .extract().as(CepDto.class);
        Assert.assertEquals(response.getCep(), CepStub.getCepStub().getCep());
        Assert.assertEquals(response.getLogradouro(), CepStub.getCepStub().getLogradouro());
        Assert.assertEquals(response.getComplemento(), CepStub.getCepStub().getComplemento());
        Assert.assertEquals(response.getUnidade(), CepStub.getCepStub().getUnidade());
        Assert.assertEquals(response.getBairro(), CepStub.getCepStub().getBairro());
        Assert.assertEquals(response.getLocalidade(), CepStub.getCepStub().getLocalidade());
        Assert.assertEquals(response.getUf(), CepStub.getCepStub().getUf());
        Assert.assertEquals(response.getIbge(), CepStub.getCepStub().getIbge());
        Assert.assertEquals(response.getGia(), CepStub.getCepStub().getGia());
        Assert.assertEquals(response.getDdd(), CepStub.getCepStub().getDdd());
        Assert.assertEquals(response.getSiafi(), CepStub.getCepStub().getSiafi());
    }
}