package br.com.viacep.bases;

import br.com.viacep.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class zipCodeValidBaseTest extends EndpointConfig {
    public static RequestSpecification baseUrl;
    public static RequestSpecification seachZipCodeRequest;
    public static ResponseSpecification seachZipCodeResponse;
    public static RequestSpecification seachZipCodeWithAddressRequest;
    public static RequestSpecification zipCodeFormatRequest;

    @BeforeClass
    public void setUp() {
        baseUrl();
        seachZipCodeRequest();
        seachZipCodeResponse();
        seachZipCodeWithAddressRequest();
        zipCodeFormatRequest();
    }

    private void baseUrl() {
        baseUrl = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setContentType(ContentType.JSON)
                .build();
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

    private void zipCodeFormatRequest() {
        zipCodeFormatRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeFormat())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void seachZipCodeWithAddressRequest() {
        seachZipCodeWithAddressRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathAddress())
                .setContentType(ContentType.JSON)
                .build();
    }
}