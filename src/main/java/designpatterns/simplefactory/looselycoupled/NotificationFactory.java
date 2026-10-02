package designpatterns.simplefactory.looselycoupled;

public class NotificationFactory {

    public static Notification sendNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SmsNotification();
        }
        throw new IllegalArgumentException("Invalid type");
    }
}
