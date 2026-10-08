package designpatterns.creational.factory;

public class SmsNotificationFactory implements NotificationFactory{
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
