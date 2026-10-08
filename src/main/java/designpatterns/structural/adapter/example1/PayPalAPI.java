package designpatterns.structural.adapter.example1;

public class PayPalAPI {
    public void makePayment(Double amount) {
        System.out.println("Made payment of: " + amount + " using PayPal.");
    }
}
