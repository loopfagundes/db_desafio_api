package br.com.viacep.bases;

import br.com.viacep.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class zipCodeErroBaseTest extends EndpointConfig {
    public static RequestSpecification seachZipCodeErroRequest;
    public static RequestSpecification seachZipCodeFakerRequest;
    public static ResponseSpecification statusOK;

    @BeforeClass
    public void setUp() {
        seachZipCodeErroRequest();
        seachZipCodeFakerRequest();
        responseStatusOK();
    }

    private void seachZipCodeErroRequest() {
        seachZipCodeErroRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeErro())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void seachZipCodeFakerRequest() {
        seachZipCodeFakerRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeFaker())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void responseStatusOK() {
        statusOK = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }
}