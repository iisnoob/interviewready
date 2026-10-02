package designpatterns.simplefactory;

public class PaymentFactory {
    public static Payment createPayment(String type) {
        if (type.equalsIgnoreCase("upi")) {
            return new UpiPayment();
        } else if (type.equalsIgnoreCase("card")) {
            return new CardPayment();
        }
        throw new IllegalArgumentException("Invalid payment type");
    }
}