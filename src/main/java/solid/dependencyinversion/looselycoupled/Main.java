package solid.dependencyinversion.looselycoupled;

public class Main {
    public static void main(String[] args) {
        OrderService sms = new OrderService(new SmsNotification());
        sms.sendNotification();

        OrderService email = new OrderService(new EmailNotification());
        email.sendNotification();
    }
}
