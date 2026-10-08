package designpatterns.structural.decorator.example1;

public class BasicRoom implements Room {

    @Override
    public double getPrice() {
        return 3000;
    }

    @Override
    public String getDescription() {
        return "Basic Room";
    }
}
