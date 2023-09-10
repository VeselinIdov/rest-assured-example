package core;

import core.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    private final RequestSpecification requestSpecification = getRequestSpec();

    private RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigurationManager.configuration().getApiURL())
                .setContentType(ContentType.JSON)
                .build().log().all();
    }

    public Response createGetRequest(String url) {
        return RestAssured
                .given(getRequestSpec())
                .get(url);
    }
    //TODO
    public Response createGetRequest(String url, int param) {
        return RestAssured
                .given(getRequestSpec())
                .get(url, param);
    }

    public Response createPostRequest(String url, Object object) {
        return RestAssured
                .given(getRequestSpec())
                .body(object)
                .post(url);
    }
}