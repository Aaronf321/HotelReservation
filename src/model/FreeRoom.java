package model;

public class FreeRoom extends Room
{
    private String roomPrice;

    public FreeRoom(String roomNumber, double roomPrice, RoomType roomType)
    {
      super(roomNumber,0,roomType);

    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomPrice=" + this.roomPrice +
                '}';
    }
}
