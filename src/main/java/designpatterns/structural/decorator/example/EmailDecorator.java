package designpatterns.structural.decorator.example;

public class EmailDecorator implements Notification {

    private final Notification notification;

    public EmailDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        notification.send();
        System.out.println("Sending Email notification...");
    }
}
