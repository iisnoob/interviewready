package designpatterns.structural.decorator.example1;

public class Main {
    public static void main(String[] args) {
        Room room = new BasicRoom();
        room = new BreakfastDecorator(room);
        room = new ExtraBedDecorator(room);
        room = new AirportPickupDecorator(room);
        System.out.println(room.getDescription());
    }
}
