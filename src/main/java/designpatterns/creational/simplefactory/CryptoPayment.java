package designpatterns.creational.simplefactory;

public class CryptoPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying using Cryptocurrency...");
    }
}
