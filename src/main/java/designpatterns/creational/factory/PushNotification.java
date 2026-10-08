package designpatterns.creational.factory;

// Concrete Product
public class PushNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}
