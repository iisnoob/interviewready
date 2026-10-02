package designpatterns.simplefactory.looselycoupled;

public class DeliveryService {
    Notification notification;

    public void sendNotification(String type) {
        if (type.equalsIgnoreCase("sms")) {
            notification = new SmsNotification();
        } else if (type.equalsIgnoreCase("email")) {
            notification = new EmailNotification();
        }

        notification.send();
    }
}
