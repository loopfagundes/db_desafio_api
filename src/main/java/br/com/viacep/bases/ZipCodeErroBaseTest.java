package br.com.viacep.bases;

import br.com.viacep.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class ZipCodeErroBaseTest extends EndpointConfig {
    public static RequestSpecification searchZipCodeErroRequest;
    public static RequestSpecification searchZipCodeFakerRequest;
    public static ResponseSpecification statusOK;

    @BeforeClass
    public void setUp() {
        searchZipCodeErroRequest();
        searchZipCodeFakerRequest();
        responseStatusOK();
    }

    private void searchZipCodeErroRequest() {
        searchZipCodeErroRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeErro())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void searchZipCodeFakerRequest() {
        searchZipCodeFakerRequest = new RequestSpecBuilder()
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