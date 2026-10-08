package designpatterns.creational.prototype.other;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HotelRoom original =
                new HotelRoom("Deluxe", "King", true, false);

        List<HotelRoom> hotelRoomList = new ArrayList<>(50);

        for (int i = 0; i < 50; i++) {

            HotelRoom room = new HotelRoom(original);

            if (i % 2 == 0) {
                room.setSeaView(true);
                room.setBedType("Queen");
            }

            hotelRoomList.add(room);
        }

        for (var x :hotelRoomList) {
            System.out.println(x.toString());
        }
    }
}
