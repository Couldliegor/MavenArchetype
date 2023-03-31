package Service;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void editEmployee(Employee employee);

    public void deleteEmployee(int id);
}
