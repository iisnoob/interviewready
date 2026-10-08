package designpatterns.creational.prototype.copy;

public class Address {
    public String city;

    public Address(String city) {
        this.city = city;
    }

    public Address(Address other) {
        this.city = other.city;
    }
}
