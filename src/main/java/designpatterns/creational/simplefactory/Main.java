package designpatterns.creational.simplefactory;

public class Main {
    public static void main(String[] args) {
        Payment upiPayment = PaymentFactory.createPayment("upi"); // one factory (i.e. 'PaymentFactory') is deciding which object to create
        upiPayment.pay();

        Payment cryptoPayment = PaymentFactory.createPayment("crypto");
        cryptoPayment.pay();

        Payment cardPayment = PaymentFactory.createPayment("card");
        cardPayment.pay();

    }
}
