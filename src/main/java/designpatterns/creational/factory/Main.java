package designpatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        NotificationFactory sms = new SmsNotificationFactory();
        sms.createNotification().send();

        NotificationFactory email = new EmailNotificationFactory();
        email.createNotification().send();

        NotificationFactory push = new PushNotificationFactory();
        push.createNotification().send();
    }
}
