package designpatterns.structural.decorator.example;

public class Main {
    public static void main(String[] args) {
        Notification simpleNotification = new BasicNotification();
        simpleNotification = new SmsDecorator(simpleNotification);
        simpleNotification = new EmailDecorator(simpleNotification);
        simpleNotification.send();
    }
}
