import Service.CityDAO;
import Service.impl.CityDAOImpl;
import Service.impl.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.SQLException;

public class Application {
    private static EmployeeDAOImpl employee = new EmployeeDAOImpl();
    private static CityDAO cityDAO = new CityDAOImpl();

    public static void main(String[] args) throws SQLException {
        City city = new City("Санкт-Пидрбург");
        cityDAO.addCity(city);
        Employee employee12 = new Employee("Hasbek", "Abdurozik", "Male", 18, city);
        employee.addEmployee(employee12);
        employee.editEmployee(2, employee12);
        employee.deleteEmployee(13);
        System.out.println(employee.getEmployeeById(7));
        System.out.println(cityDAO.getAllCities());
        System.out.println(employee.getAllEmployees());
          System.out.println(employee.getEmployeeById(18));
        System.out.println(cityDAO.getAllCities());
        for (City allCity : cityDAO.getAllCities()) {
            System.out.println(allCity.getEmployee());
        }
    }
}
