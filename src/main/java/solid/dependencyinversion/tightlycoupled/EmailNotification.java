package solid.dependencyinversion.tightlycoupled;

public class EmailNotification {
    public void send() {
        System.out.println("Email: The order has been placed!");
    }
}
