package designpatterns.structural.decorator.example;

public class SmsDecorator implements Notification {

    private final Notification notification;

    public SmsDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        notification.send();
        System.out.println("Sending SMS notification...");
    }
}
