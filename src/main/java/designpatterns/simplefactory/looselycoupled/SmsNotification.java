package designpatterns.simplefactory.looselycoupled;

public class SmsNotification implements Notification{
    @Override
    public void send() {
        System.out.println("SMS: The order has been placed!");
    }
}
