package br.com.viacep.bases;

import br.com.viacep.utils.Endpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class SeachZipCodeBaseTest extends Endpoint {
    public static RequestSpecification seachZipCodeRequest;
    public static ResponseSpecification seachZipCodeResponse;

    @BeforeClass
    public void setUp() {
        seachZipCodeRequest();
        seachZipCodeResponse();
    }

    private void seachZipCodeRequest() {
        seachZipCodeRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCode())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void seachZipCodeResponse() {
        seachZipCodeResponse = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }
}