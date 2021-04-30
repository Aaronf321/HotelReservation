package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService
{
    private static  ReservationService reservationService = null;
    public List<IRoom> roomList = new ArrayList<>();




    Collection<Reservation> reservationList = new HashSet<>();
    Reservation reserveRoom;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationService that = (ReservationService) o;
        return reservationList.equals(that.reservationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationList);
    }


    public void addRoom(IRoom room)
    {
        roomList.add(room);
    }

    public IRoom getARoom(String roomNumber)
    {
       for(IRoom room : roomList)
       {
           if(room.getRoomNumber().equals(roomNumber))
               return room;
       }
       return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate,Date checkOutDate)
    {

        reservationList.add(new Reservation(customer,room,checkInDate,checkOutDate));
        return reserveRoom;
    }

    public Collection<IRoom> findRooms (Date checkInDate,Date checkOutDate)
    {
        Collection<IRoom>displayList = new ArrayList<IRoom>();
        if(reservationList.isEmpty())
        {
            getRoomList();
        }else {
            for (Reservation checkInOut : reservationList) {
                if (checkInOut.getCheckInDate().after(checkInDate) && checkInOut.getCheckOutDate().before(checkOutDate)){
                    IRoom currentRoom = checkInOut.getRoom();
                    displayList.add(currentRoom);
                }
            }
        }
        return displayList;
    }


    public Collection<Reservation> getCustomerReservation(Customer customer)
    {
        Collection<Reservation> reservations = new ArrayList<>();
        try{
            for (Reservation customerReservation : reservationList) {
                if (customerReservation.getCustomer().equals(customer)) {
                    reservations.add(customerReservation);
                    System.out.println(reservations);
                } else {
                    System.out.println("Reservation not found.");
                }
                return reservations;
            }
        }catch (NullPointerException e)
        {
            System.out.println("This does not exist");
        }
        return reservations;
    }
    /**
     * figure out how to return customer reservation from map (I think)
     */

    public void printAllReservation()
    {
        System.out.println(reservationList.toString());
    }

    public Collection<IRoom> getRoomList() {
        for (IRoom iRoom : roomList) {
            System.out.println(iRoom);
        }
        return roomList;
    }


}
