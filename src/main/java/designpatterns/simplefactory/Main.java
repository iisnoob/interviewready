package designpatterns.simplefactory;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.createPayment("upi"); // one factory (i.e. 'PaymentFactory') is deciding which object to create
        payment.pay();
    }
}
