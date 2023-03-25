package Service;

import Model.City;

import java.util.List;

public interface CityDAO {
    void addEmployee(City city);

    City getCityById(int id);

    List<City> getAllCities();

    void editCity(int id, City city);

    void deleteCity(int id);
}
