package br.com.viacep.bases;

import br.com.viacep.utils.Endpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class SeachZipCodeInvalidBaseTest extends Endpoint {
    public static RequestSpecification seachZipCodeInvalidRequest;
    public static ResponseSpecification seachZipCodeInvalidResponse;
    public static RequestSpecification seachZipCodeFakerRequest;
    public static ResponseSpecification seachZipCodeFakerResponse;

    @BeforeClass
    public void setUp() {
        seachZipCodeInvalidRequest();
        seachZipCodeInvalidResponse();
        seachZipCodeFakerRequest();
        seachZipCodeFakerResponse();
    }

    private void seachZipCodeInvalidRequest() {
        seachZipCodeInvalidRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeInvalid())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void seachZipCodeInvalidResponse() {
        seachZipCodeInvalidResponse = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }

    private void seachZipCodeFakerRequest() {
        seachZipCodeFakerRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeFaker())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void seachZipCodeFakerResponse() {
        seachZipCodeFakerResponse = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }
}