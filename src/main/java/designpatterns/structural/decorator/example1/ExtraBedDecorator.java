package designpatterns.structural.decorator.example1;

public class ExtraBedDecorator implements Room {

    private final Room hotelRoom;

    public ExtraBedDecorator(Room hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    @Override
    public double getPrice() {
        return hotelRoom.getPrice() + 800;
    }

    @Override
    public String getDescription() {
        return "Extra Bed";
    }
}
