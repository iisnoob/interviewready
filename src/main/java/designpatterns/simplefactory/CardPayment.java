package designpatterns.simplefactory;

public class CardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying using Credit Card...");
    }
}
