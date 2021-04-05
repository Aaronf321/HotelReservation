package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService
{
    public static final ReservationService reservationService = new ReservationService();
    //Map<>roomMap = new HashMap<>();
    List<IRoom> roomList = new ArrayList<IRoom>();
    public ReservationService()
    {

    }
    public void addRoom(IRoom room)
    {
        roomList.add(room);
    }

//    public IRoom getARoom(String roomId)
//    {
//        return
//    }
//
//    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate,Date checkOutDate)
//    {
//        return
//    }
//
//    public Collection<IRoom> findRooms (Date checkInDate,Date CheckOutDate)
//    {
//        return
//    }
//
//    public Collection<Reservation> getCustomerReservation(Customer customer)
//    {
//
//    }
//
//    public void printAllReservation()
//    {
//
//    }



}
