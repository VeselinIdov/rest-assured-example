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
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .get(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }

    public Response getRequest(String url) {
        Response response = RestAssured
                .given(getRequestSpec())
                .get(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }

    public Response postRequest(String url, Object object) {
        Response response = RestAssured
                .given(getRequestSpec())
                .body(object)
                .post(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }

    public Response postRequest(String url, Object object, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .post(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }

    public Response patchRequest(String url, Object object, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .patch(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }

    public Response putRequest(String url, Object object, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .put(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }

    public Response deleteRequest(String url, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .delete(url);
        LoggerUtils.logInfo(response.prettyPrint());
        return response;
    }
}