package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private int livingCityId;
    private String livingCity;

    public Employee(String firstName, String lastName, String gender, int age, String livingCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.livingCity = livingCity;
    }

    public Employee(int id, String firstName, String lastName, String gender, int age, String livingCity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.livingCity = livingCity;
    }

    public Employee(String firstName, String lastName, String gender, int age, int livingCityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.livingCityId = livingCityId;
    }

    public Employee() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLivingCityId() {
        return livingCityId;
    }

    public void setLivingCityId(int livingCityId) {
        this.livingCityId = livingCityId;
    }
}
