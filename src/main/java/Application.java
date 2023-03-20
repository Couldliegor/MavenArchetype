import Model.Employee;
import Service.impl.EmployeeDAOImpl;
import java.sql.*;

public class Application {
    private static EmployeeDAOImpl employee = new EmployeeDAOImpl();
    public static void main(String[] args) throws SQLException {
                Employee employee12 = new Employee(12,"Abdul", "Lolsl", "Male", 19, 1);
                employee.addEmployee(employee12);
                employee.deleteEmployee(13);
                employee.editEmployee(2, employee12);
                System.out.println(employee.getAllEmployees());
                System.out.println(employee.getEmployeeById(7));
    }
}
