package designpatterns.simplefactory.tightlycoupled;

public class SmsNotification {
    public void send() {
        System.out.println("SMS: The order has been placed!");
    }
}
