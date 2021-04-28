package model;

public class Room implements IRoom
{
    private String roomNumber;
    private double roomPrice;
    private RoomType roomType;
    private boolean roomIsFree;


    public Room(String roomNumber,double roomPrice,RoomType roomType)
    {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.roomIsFree = roomIsFree;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return roomPrice;
    }



    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isFree()
    {
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomType=" + roomType +
                '}';
    }
}
