package br.com.viacep.testcases.performance;

import br.com.viacep.bases.zipCodeValidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PerformaceTest extends zipCodeValidBaseTest {

    @Epic("Teste de Performance")
    @Feature("Teste de alto desempenho resposta com CEP valido.")
    @Description("O método de rapido resposta com CEP deve retornar o status 200.")
    @Test
    public void quicklyForValidZipCodeSuccessfully200() {
        given()
                    .spec(seachZipCodeRequest)
                .when()
                    .get()
                .then()
                    .spec(statusOK)
                    .time(lessThan(3000L));
    }
}