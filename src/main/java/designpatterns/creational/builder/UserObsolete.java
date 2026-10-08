package designpatterns.creational.builder;

/**
 * Setting the fields will be lethargic, hence we use the Builder pattern*/
public class UserObsolete {
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private String email;
    // suppose more fields
    // solution: Builder Pattern

    public String getName() {
        return name;
    }

    public UserObsolete() {
    }

    public UserObsolete(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserObsolete(String name, Integer age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public UserObsolete(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public UserObsolete(String name) {
        this.name = name;
    }

    public UserObsolete(String name, Integer age, String gender, String address, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
