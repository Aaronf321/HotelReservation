package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService
{
    private static  ReservationService reservationService = null;
    private int roomId;
    Map<Integer,IRoom>roomMap = new HashMap<Integer,IRoom>();
    Map<Customer,Reservation>reservationMap = new HashMap<Customer,Reservation>();
    //List<IRoom> roomList = new ArrayList<IRoom>();

    Collection<IRoom> roomList = new ArrayList<>();
    Collection<Reservation> reservationList = new ArrayList<Reservation>();
    Reservation mapValue;

    private ReservationService(){
    }

    public static ReservationService getInstance()
    {
        if(null == reservationService)
        {
            reservationService = new ReservationService();
        }
        return reservationService;
    }
    public void addRoom(IRoom room)
    {
        roomId++;
        roomList.add(room);
        roomMap.put(roomId,room);

    }

    public IRoom getARoom(String roomId)
    {
        if(!roomMap.containsKey(this.roomId)) {
            System.out.println("Room ID not found");
        }else
        {
            System.out.println("Room found!");
        }
        return  roomMap.get(this.roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate,Date checkOutDate)
    {
        Reservation reserveRoom = new Reservation(customer,room,checkInDate,checkOutDate);
        reservationList.add(reserveRoom);
        reservationMap.put(customer,reserveRoom);
        return reserveRoom;
    }

    public Collection<IRoom> findRooms (Date checkInDate,Date checkOutDate)
    {
        Collection<IRoom>displayList = new ArrayList<IRoom>();
        for(Reservation checkInOut : reservationList )
        {
            if(reservationList.contains(checkInDate))
            {
                IRoom currentRoom = checkInOut.getRoom();
               displayList.add(currentRoom);
            }
        }

        for(Reservation checkInOut : reservationList )
        {
            if(reservationList.contains(checkOutDate))
            {
                IRoom currentRoom = checkInOut.getRoom();
                displayList.add(currentRoom);
            }
        }

        return displayList;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer)
    {
      if(reservationMap.containsKey(customer))
      {
          Reservation mapValue = reservationMap.get(customer);
      }else
      {
          System.out.println("Reservation not found!. . .");
      }
      return reservationList.get(0);

    }
    /**
     * figure out how to return customer reservation from map (I think)
     */

//    public void printAllReservation()
//    {
//
//    }


    public int getRoomId() {
        return roomId;
    }
}
