package core;

import core.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.DecoderConfig;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RestAssuredConfig.config;

public class BaseRequest {

    private final RequestSpecification requestSpecification = getRequestSpec();

    public RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigurationManager.configuration().getApiURL())
                .setContentType(ContentType.JSON)
                .build().log().all();
    }

    public Response createGetRequest(String url, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .get(url);
    }

    public Response createGetRequest(String url) {
        return RestAssured
                .given(getRequestSpec())
                .get(url);
    }

    public Response createPostRequest(String url, Object object) {
        return RestAssured
                .given(getRequestSpec())
                .body(object)
                .post(url);
    }

    public Response createPutRequest(String url, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .put(url);
    }

    public Response createDeleteRequest(String url, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .delete(url);
    }

    public BaseRequest setPathParams(String string, Object object) {
        getRequestSpec().pathParams(string, object);
        return this;
    }
}