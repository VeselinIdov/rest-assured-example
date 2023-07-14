import core.JsonExtractor;
import enums.StatusCode;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.EmployeeResponse;
import requests.EmployeeRequests;

class ExampleTests {

    @Test
    void getEmployeeTest() {
        Response response = new EmployeeRequests().getAllEmployee();

        System.out.println(response);
    }

    @Test
    void createEmployeeTest() {
        Response response = new EmployeeRequests().createEmployee();
        EmployeeResponse employeeResponse = JsonExtractor.objectMapper(response.prettyPrint(), EmployeeResponse.class);
        Assertions.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getValue());

    }
}