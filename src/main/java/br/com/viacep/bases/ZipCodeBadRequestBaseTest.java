package br.com.viacep.bases;

import br.com.viacep.endponits.EndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class ZipCodeBadRequestBaseTest extends EndpointConfig {
    public static RequestSpecification baseUrl;
    public static RequestSpecification zipCodeEmptyRequest;
    public static RequestSpecification zipCodePublicAreaNotExisteRequest;
    public static RequestSpecification zipCodeCityNotExisteRequest;
    public static RequestSpecification zipCodeUFNotExistRequest;
    public static ResponseSpecification statusBadRequest;

    @BeforeClass
    public void setUp() {
        baseUrl();
        zipCodeEmptyRequest();
        zipCodePublicAreaNotExisteRequest();
        zipCodeCityNotExisteRequest();
        zipCodeUFNotExistRequest();
        responseStatusBadRequest();
    }

    private void baseUrl() {
        baseUrl = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .build();
    }

    private void zipCodeEmptyRequest() {
        zipCodeEmptyRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeEmpty() + "/json")
                .setContentType(ContentType.JSON)
                .build();
    }

    private void zipCodePublicAreaNotExisteRequest() {
        zipCodePublicAreaNotExisteRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodePublicAreaNotExist())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void zipCodeCityNotExisteRequest() {
        zipCodeCityNotExisteRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeCityNotExist())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void zipCodeUFNotExistRequest() {
        zipCodeUFNotExistRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathZipCodeUFNotExist())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void responseStatusBadRequest() {
        statusBadRequest = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }
}