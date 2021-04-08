package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource
{
    public static final AdminResource adminResource = new AdminResource();
    public static final ReservationService reservationService = ReservationService.getInstance();
   public AdminResource() {}

    public Customer getCustomer(String email)
    {
        return CustomerService.customerService.getCustomer(email);
    }

    /**
     *
     * add room not working. Need to pass in a list instead of room object!!!
     */


    public void addRoom(List<IRoom> rooms)
    {
        //ReservationService.reservationService.addRoom(ReservationService.reservationService.addRoom());
        for(IRoom room : rooms)
        {
            reservationService.addRoom(room);
        }

    }

//    public Collection<IRoom> getAllRooms()
//    {
//        return
//    }

//    public Collection<Customer>getAllCustomers()
//    {
//
//    }
//
//    public void displayAllReservations()
//    {
//
//    }



}
