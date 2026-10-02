package designpatterns.simplefactory;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.createPayment("upi");
        payment.pay();
    }
}
