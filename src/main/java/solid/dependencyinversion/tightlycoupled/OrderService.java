package solid.dependencyinversion.tightlycoupled;

/**
 * It is tightly coupled because:
 * OrderService is dependent on EmailNotification, SmsNotification
 *
 * So if we were to include (say) another notification like PushNotification
 * we would have to modify OrderService (every single time). This can even lead
 * to the violation of 'Open-Closed Principle' in SOLID - which states that regression should
 * not break (i.e. production-working code should not be changed).*/
public class OrderService {

    EmailNotification emailNotification = new EmailNotification();
    SmsNotification smsNotification = new SmsNotification();

    public void sendNotificationEmail() {
        emailNotification.send();
    }

    public void sendNotificationSms() {
        smsNotification.send();
    }

}
