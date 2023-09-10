package requests;

import core.BaseRequest;
import io.restassured.response.Response;
import pojo.EmployeeRequestPOJO;

public class EmployeeRequests extends BaseRequest {
    private static final String CREATE_EMPLOYEE_PATH = "create";
    private static final String GET_EMPLOYEE_PATH = "employees/";

    public Response getAllEmployee() {
        return this.createGetRequest(GET_EMPLOYEE_PATH);
    }

    public Response getAllEmployee(int id) {
        return this.createGetRequest(GET_EMPLOYEE_PATH, id);
    }

    public Response createEmployee(EmployeeRequestPOJO employeeRequestBody) {
        return this.createPostRequest(CREATE_EMPLOYEE_PATH, employeeRequestBody);
    }
}