import com.github.javafaker.Faker;
import core.JsonExtractor;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.EmployeeRequestPOJO;
import pojo.EmployeeResponse;
import requests.EmployeeRequests;

class ExampleTests {
    Faker faker = new Faker();

    @Test
    void getEmployeeTest() {
        new EmployeeRequests().getEmployees();
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

        var response = new EmployeeRequests().createEmployee(employeeRequest);
        EmployeeResponse employeeResponse = JsonExtractor.objectMapper(response.prettyPrint(), EmployeeResponse.class);
        System.out.println(response.statusCode());
    }

    @Test
    void updateEmployeeTest() {
        EmployeeRequestPOJO employeeRequest = new EmployeeRequestPOJO();
        employeeRequest.setName(faker.name().firstName());
        employeeRequest.setSalary(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());
        employeeRequest.setAge(faker.number().digit());

        Response response = new EmployeeRequests().updateEmployee(employeeRequest, "1");
        System.out.println(response.statusCode());
    }

    @Test
    void deleteEmployeeTest() {
        Response response = new EmployeeRequests().deleteEmployeeById("1");
        System.out.println(response.statusCode());
    }
}