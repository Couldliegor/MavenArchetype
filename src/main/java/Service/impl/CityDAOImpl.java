package Service.impl;

import Configuration.HibernateSessionFactoryUtil;
import Model.City;
import Service.CityDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void addEmployee(City city) {
        // В ресурсах блока try создаем объект сессии с помощью нашего конфиг-файла
        // И открываем сессию
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // Создаем транзакцию и начинаем ее
            Transaction transaction = session.beginTransaction();
            // вызываем на объекте сессии метод save
            // данный метод внутри себя содержит необходимый запрос к базе
            // для создания новой строки
            session.save(city);
            // Выполняем коммит, то есть сохраняем изменения,
            // которые совершили в рамках транзакции
            transaction.commit();
        }
    }

    @Override
    public City getCityById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    @Override
    public List<City> getAllCities() {
        List<City> cityList = (List<City>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From City").list();
        return cityList;
    }

    @Override
    public void editCity(int id, City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            // Для обновления данных нужно передать в конструктор
            // объект с актуальными данными
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            // Для удаления объекта из таблицы нужно передать его в метод delete
            session.delete(getCityById(id));
            transaction.commit();
        }
    }
}
