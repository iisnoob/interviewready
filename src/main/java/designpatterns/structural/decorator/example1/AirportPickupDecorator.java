package designpatterns.structural.decorator.example1;

public class AirportPickupDecorator implements Room {

    private final Room hotelRoom;

    public AirportPickupDecorator(Room hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    @Override
    public double getPrice() {
        return hotelRoom.getPrice() + 1000;
    }

    @Override
    public String getDescription() {
        return "Airport Pickup";
    }
}
