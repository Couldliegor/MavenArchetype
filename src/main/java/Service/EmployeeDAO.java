package Service;

import Model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int id) throws SQLException;

    List<Employee> getAllEmployees();

    void editEmployee(int id, String first_name, String last_name, String gender, int age);

    void deleteEmployee(int id);
}
