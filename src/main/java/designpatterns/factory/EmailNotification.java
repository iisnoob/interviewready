package designpatterns.factory;

// Concrete Product
public class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
