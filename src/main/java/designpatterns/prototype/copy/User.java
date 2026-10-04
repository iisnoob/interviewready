package designpatterns.prototype.copy;

public class User {
    public String name;
    public Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }
}
