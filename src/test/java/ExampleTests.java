import com.github.javafaker.Faker;
import core.JsonExtractor;
import enums.StatusCode;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.EmployeeRequestPOJO;
import pojo.EmployeeResponse;
import requests.EmployeeRequests;

class ExampleTests {
    Faker faker = new Faker();


    @Test
    void getEmployeeTest() {
        Response employeeResponse = new EmployeeRequests().getAllEmployee();
        Response employeeResponseWithParam = new EmployeeRequests().getAllEmployee(1);
        System.out.println(employeeResponseWithParam.prettyPrint());
    }

    @Test
    void createEmployeeTest() {
        EmployeeRequestPOJO employeeRequest = new EmployeeRequestPOJO();
        employeeRequest.setName(faker.name().firstName());
        employeeRequest.setSalary(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());

        Response response = new EmployeeRequests().createEmployee(employeeRequest);
        EmployeeResponse employeeResponse = JsonExtractor.objectMapper(response.prettyPrint(), EmployeeResponse.class);
        Assertions.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getValue());
        System.out.println(employeeResponse.getMessage());
    }
}