package designpatterns.simplefactory.looselycoupled;

/**
 * It is tightly coupled because:
 * OrderService is dependent on EmailNotification, SmsNotification
 * <p>
 * So if we were to include (say) another notification like PushNotification
 * we would have to modify OrderService (every single time). This can even lead
 * to the violation of 'Open-Closed Principle' in SOLID - which states that regression should
 * not break (i.e. production-working code should not be changed).
 */
public class OrderService {
    public void sendNotification() {
        Notification notification = NotificationFactory.sendNotification("email");
        notification.send();
    }
}
