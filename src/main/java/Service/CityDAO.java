package Service;

import model.City;

import java.util.List;

public interface CityDAO {
    void addCity(City city);

    City getCityById(int id);

    List<City> getAllCities();

    void editCity(City city);

    void deleteCity(int id);
}
