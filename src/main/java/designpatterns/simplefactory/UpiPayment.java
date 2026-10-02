package designpatterns.simplefactory;

public class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying using UPI...");
    }
}
