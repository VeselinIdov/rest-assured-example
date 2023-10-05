package requests;

import core.BaseRequest;
import io.restassured.response.Response;
import pojo.EmployeeRequestPOJO;

public class EmployeeRequests extends BaseRequest {
    private static final String CREATE_EMPLOYEE_PATH = "create";
    private static final String GET_EMPLOYEE_PATH = "employees";
    private static final String GET_EMPLOYEE_PATH_WITH_PARAM = "employee";
    private static final String UPDATE_EMPLOYEE_PATH_WITH_PARAM = "update";
    private static final String DELETE_EMPLOYEE_PATH_WITH_PARAM = "delete";

    public Response getEmployees() {
        return this.getRequest(GET_EMPLOYEE_PATH);
    }

    public Response getEmployeeById(String id) {
       return this.getRequest(GET_EMPLOYEE_PATH_WITH_PARAM + "/{id}", id);

    }

    public Response createEmployee(EmployeeRequestPOJO employeeRequestBody) {
        return this.postRequest(CREATE_EMPLOYEE_PATH, employeeRequestBody);
    }

    public Response updateEmployee(EmployeeRequestPOJO employeeRequestBody, String id) {
        return this.putRequest(UPDATE_EMPLOYEE_PATH_WITH_PARAM + "/{id}", employeeRequestBody, id);
    }

    public Response deleteEmployeeById(String id) {
        return this.deleteRequest(DELETE_EMPLOYEE_PATH_WITH_PARAM + "/{id}", id);
    }
}