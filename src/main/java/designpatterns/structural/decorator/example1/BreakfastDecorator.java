package designpatterns.structural.decorator.example1;

public class BreakfastDecorator implements Room {

    private final Room hotelRoom;

    public BreakfastDecorator(Room hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    @Override
    public double getPrice() {
        return hotelRoom.getPrice() + 500;
    }

    @Override
    public String getDescription() {
        return "Breakfast";
    }
}
