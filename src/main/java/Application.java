import Model.Employee;
import Service.impl.EmployeeDAOImpl;

import java.sql.*;

public class Application {
    private static final EmployeeDAOImpl employee;
    static {
        try {
            employee = new EmployeeDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws SQLException {
        String user = "postgres";
        String password = "Couldlie";
        String url = "jdbc:postgresql://localhost:5433/skypro";
        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee INNER JOIN city ON employee.living_city_id = city.city_id WHERE id = (?)");
            preparedStatement.setInt(1, 6);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String first_name = "First name: " + resultSet.getString("first_name");
                String last_name = "Last name: " + resultSet.getString("last_name");
                String gender = "gender: " + resultSet.getString("gender");
                String age = "Age: " + resultSet.getString("age");
                String city = "City: " + resultSet.getString("city_name");

                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city);
                Employee employee1 = new Employee("Egor", "Kudlay", "Male", 18, 1);
                employee.addEmployee(employee1);
                employee.deleteEmployee(10);
                employee.editEmployee(7, "Zlata", "Morova", "Female", 19);
                System.out.println(employee.getAllEmployees());
                employee.getEmployeeById(7);

                //чтобы все было прям вообще идеально, мне захотелось написать тест ))))
                //но возникло большое НО с некоторыми методами ...( описал на скрине =))
            }
        }
    }
}
