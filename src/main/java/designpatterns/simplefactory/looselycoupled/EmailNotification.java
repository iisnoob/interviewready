package designpatterns.simplefactory.looselycoupled;

public class EmailNotification implements Notification{
    @Override
    public void send() {
        System.out.println("Email: The order has been placed!");
    }
}
