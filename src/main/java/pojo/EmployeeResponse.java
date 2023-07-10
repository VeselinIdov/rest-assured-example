package pojo;
import lombok.Getter;
@Getter
public class EmployeeResponse {
    private String status;
    private String message;
    private Data data;
    @Getter
    public class Data {
        private String name;
        private String salary;
        private String age;
        private String id;
    }
}