package Service.impl;

import Model.Employee;
import Service.EmployeeDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "Couldlie";
    final String url = "jdbc:postgresql://localhost:5433/skypro";
    final Connection connection  = DriverManager.getConnection(url, user, password);

    public EmployeeDAOImpl() throws SQLException {
    }
    @Override
    public void addEmployee(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, living_city_id) VALUES ((?),(?),(?),(?),(?))")) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getLivingCityId());
            // С помощью метода executeQuery отправляем запрос к базе
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        Employee employee = new Employee();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee INNER JOIN city ON employee.living_city_id = city.city_id WHERE id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setLivingCity(resultSet.getString("city_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee INNER JOIN city ON city.city_id = employee.living_city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String livingCity = resultSet.getString("city_name");

                Employee employee = new Employee(id, firstName, last_name, gender, age, livingCity);
                list.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void editEmployee(int id, String first_name, String last_name, String gender, int age) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?) WHERE id = (?)")) {
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, id);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

// создать модели
