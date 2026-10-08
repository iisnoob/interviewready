package designpatterns.creational.builder;

public class UserBuilder {
     String name;
     Integer age;
     String gender;
     String address;
     String email;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
}
