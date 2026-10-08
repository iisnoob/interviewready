package designpatterns.creational.prototype;

import designpatterns.creational.prototype.copy.Address;
import designpatterns.creational.prototype.copy.User;

public class Main {
    public static void main(String[] args) {

        // Shallow copy: Creates a new outer object, but does not copy the objects referenced inside it.
        Address address1 = new Address("Lucknow");
        User user1 = new User("Amber", address1);
        System.out.println(user1.getName() + ", " + user1.address.city);

        User user2 = new User("Mustafa", user1.address);
        user2.address.city = "Bombay";

        System.out.println(user1.name + ", " + user1.address.city);

        // Deep copy: New outer object + copy objects referenced inside it.
        User user3 = new User(user1.name, new Address(user1.address.city));
        user3.address.city = "Hong Kong";

        System.out.println(user1.name + ", " + user1.address.city);
        System.out.println(user3.name + ", " + user3.address.city);

        // Deep copy using copy constructor
        User user4 = new User(
                user3.name,
                new Address(user1.address)
        );

        System.out.println(user4.name + ", " + user4.address.city);

    }
}
