package designpatterns.simplefactory.tightlycoupled;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.sendNotificationSms();
        orderService.sendNotificationEmail();
    }
}
