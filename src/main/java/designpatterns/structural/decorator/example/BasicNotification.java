package designpatterns.structural.decorator.example;

public class BasicNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Notification...");
    }
}
