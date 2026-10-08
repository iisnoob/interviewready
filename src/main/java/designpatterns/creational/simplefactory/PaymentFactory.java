package designpatterns.creational.simplefactory;

public class PaymentFactory {
    public static Payment createPayment(String type) {
        if (type.equalsIgnoreCase("upi")) {
            return new UpiPayment();
        } else if (type.equalsIgnoreCase("card")) {
            return new CardPayment();
        } else if (type.equalsIgnoreCase("crypto")) {
            return new CryptoPayment();
        }
        throw new IllegalArgumentException("Invalid payment type");
    }
}