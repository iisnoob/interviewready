package designpatterns.creational.prototype.other;

class HotelRoom {

    private String roomType;
    private String bedType;
    private boolean breakfast;
    private boolean seaView;

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "roomType='" + roomType + '\'' +
                ", bedType='" + bedType + '\'' +
                ", breakfast=" + breakfast +
                ", seaView=" + seaView +
                '}';
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    HotelRoom(String roomType, String bedType,
              boolean breakfast, boolean seaView) {
        this.roomType = roomType;
        this.bedType = bedType;
        this.breakfast = breakfast;
        this.seaView = seaView;
    }

    // Copy constructor
    HotelRoom(HotelRoom other) {
        this.roomType = other.roomType;
        this.bedType = other.bedType;
        this.breakfast = other.breakfast;
        this.seaView = other.seaView;
    }
}
