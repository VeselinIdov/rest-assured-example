package requestbuilders;
import pojo.EmployeeRequestPOJO;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilders {

    public static Map<String, String> getEmployeeRequestBuilder(EmployeeRequestPOJO employeeRequestPOJO) {
        Map<String, String> employeeBody = new HashMap<>();
        employeeBody.put("name", employeeRequestPOJO.getName());
        employeeBody.put("salary", employeeRequestPOJO.getSalary());
        employeeBody.put("age", employeeRequestPOJO.getAge());
        return employeeBody;
    }
}