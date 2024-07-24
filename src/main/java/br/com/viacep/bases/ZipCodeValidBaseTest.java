package br.com.viacep.bases;

import br.com.viacep.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class ZipCodeValidBaseTest extends EndpointConfig {
    public static RequestSpecification baseUrl;
    public static RequestSpecification seachZipCodeRequest;
    public static RequestSpecification seachZipCodeWithAddressRequest;
    public static RequestSpecification zipCodeFormattingRequest;
    public static ResponseSpecification statusOK;

    @BeforeClass
    public void setUp() {
        baseUrl();
        seachZipCodeRequest();
        seachZipCodeWithAddressRequest();
        zipCodeFormattingRequest();
        responseStatusOK();
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

    private void zipCodeFormattingRequest() {
        zipCodeFormattingRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeFormatting())
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

    private void responseStatusOK() {
        statusOK = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }
}