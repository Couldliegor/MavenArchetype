import Service.CityDAO;
import Service.impl.CityDAOImpl;
import Service.impl.EmployeeDAOImpl;

import java.sql.SQLException;

public class Application {
    private static EmployeeDAOImpl employee = new EmployeeDAOImpl();
    private static CityDAO cityDAO = new CityDAOImpl();

    public static void main(String[] args) throws SQLException {
//        Employee employee12 = new Employee(12, "Abdul", "Lolsl", "Male", 19, 1);
//        employee.addEmployee(employee12);
//        employee.editEmployee(2, employee12);
//        employee.deleteEmployee(13);
//        System.out.println(employee.getEmployeeById(7));
//        City city = new City();
//        System.out.println(cityDAO.getAllCities());
//        System.out.println(employee.getAllEmployees());
          System.out.println(employee.getEmployeeById(18));
    }
}
