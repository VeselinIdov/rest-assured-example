import core.JsonExtractor;
import io.restassured.response.Response;
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
        EmployeeResponse student = JsonExtractor.objectMapper(response.prettyPrint(), EmployeeResponse.class);

        System.out.println(student.getData().getId());
        System.out.println(student.getMessage());
        System.out.println(response.getStatusCode());
    }
}