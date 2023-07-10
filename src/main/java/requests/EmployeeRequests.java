package requests;
import com.github.javafaker.Faker;
import core.BaseRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.EmployeeRequestPOJO;
import requestbuilders.RequestBuilders;

public class EmployeeRequests extends BaseRequest {
    Faker faker = new Faker();
    private static final String CREATE_EMPLOYEE_PATH = "create";
    private static final String GET_EMPLOYEE_PATH = "employees";

    public Response getAllEmployee() {
        return RestAssured
                .given(getRequestSpec())
                .get(GET_EMPLOYEE_PATH);
    }

    public Response createEmployee() {
        EmployeeRequestPOJO employeeRequestPOJO = new EmployeeRequestPOJO();
        employeeRequestPOJO.setName(faker.name().firstName());
        employeeRequestPOJO.setSalary(faker.number().digit());
        employeeRequestPOJO.setAge(faker.number().digit());
        employeeRequestPOJO.setAge(faker.number().digit());
        employeeRequestPOJO.setAge(faker.number().digit());
        employeeRequestPOJO.setAge(faker.number().digit());

        return RestAssured.given(getRequestSpec())
                .body(RequestBuilders.getEmployeeRequestBuilder(employeeRequestPOJO))
                .post(CREATE_EMPLOYEE_PATH);
    }
}