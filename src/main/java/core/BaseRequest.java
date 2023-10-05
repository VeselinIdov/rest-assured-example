package core;

import core.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    public RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigurationManager.configuration().getApiURL())
                .setContentType(ContentType.JSON)
                .build().log().all();
    }

    public Response getRequest(String url, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .get(url);
    }

    public Response getRequest(String url) {
        return RestAssured
                .given(getRequestSpec())
                .get(url);
    }

    public Response postRequest(String url, Object object) {
        return RestAssured
                .given(getRequestSpec())
                .body(object)
                .post(url);
    }

    public Response postRequest(String url, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .post(url);
    }

    public Response patchRequest(String url, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .patch(url);
    }

    public Response putRequest(String url, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .put(url);
    }

    public Response deleteRequest(String url, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .delete(url);
    }
}