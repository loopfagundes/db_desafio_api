package br.com.viacep.testcases;

import br.com.viacep.bases.SeachZipCodeBaseTest;
import br.com.viacep.dto.CepDto;
import br.com.viacep.stubs.CepStub;
import br.com.viacep.utils.ExpectedJson;
import br.com.viacep.utils.JsonResponseSaver;
import io.qameta.allure.Feature;
import org.testng.Assert;
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
                    .log().body()
                .spec(seachZipCodeResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("validatorZipCode.json")));
    }

    @Feature("GET - BUSCAR O CEP COM ENDEREÇO")
    @Test(
            description = "O metodo de buscar o cep com endereço.",
            priority = 2
    )
    public void seachZipCodeAddressSuccessfully200() throws IOException {
        given()
                .spec(seachZipCodeAddressRequest)
                .when()
                    .get()
                .then()
                    .log().body()
                .spec(seachZipCodeResponse)
                    .assertThat().body(matchesJsonSchema(ExpectedJson.json("validatorZipCodeAddress.json")));
    }

    @Feature("GET - BUSCAR COM O STUB")
    @Test(
            description = "O metodo de buscar o cep com Stub"
    )
    public void seachZipCodeStubSuccessfully200() {
        CepDto response = given()
                .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                .spec(seachZipCodeResponse)
                    .log().body()
                    .extract().as(CepDto.class);
        Assert.assertEquals(response.getCep(), CepStub.cepStub().getCep());
        Assert.assertEquals(response.getLogradouro(), CepStub.cepStub().getLogradouro());
        Assert.assertEquals(response.getComplemento(), CepStub.cepStub().getComplemento());
        Assert.assertEquals(response.getUnidade(), CepStub.cepStub().getUnidade());
        Assert.assertEquals(response.getBairro(), CepStub.cepStub().getBairro());
        Assert.assertEquals(response.getLocalidade(), CepStub.cepStub().getLocalidade());
        Assert.assertEquals(response.getUf(), CepStub.cepStub().getUf());
        Assert.assertEquals(response.getIbge(), CepStub.cepStub().getIbge());
        Assert.assertEquals(response.getGia(), CepStub.cepStub().getGia());
        Assert.assertEquals(response.getDdd(), CepStub.cepStub().getDdd());
        Assert.assertEquals(response.getSiafi(), CepStub.cepStub().getSiafi());
    }
}