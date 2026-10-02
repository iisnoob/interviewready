package solid.dependencyinversion.looselycoupled;

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
    private final Notification notification;

    public OrderService(Notification notification) {
        this.notification = notification;
    }

    public void sendNotification() {
        notification.send();
    }
}
