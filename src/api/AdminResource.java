package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource
{
    private static AdminResource adminResource = null;

    public static AdminResource getInstance()
    {
        if(null == adminResource)
        {
            adminResource = new AdminResource();
        }
        return adminResource;
    }
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static final CustomerService customerService = CustomerService.getInstance();
    public AdminResource() {}

    public Customer getCustomer(String email)
    {
        return customerService.getCustomer(email);
    }




    public void addRoom(List<IRoom> rooms)
    {
        for(IRoom room : rooms)
        {
            reservationService.addRoom(room);
        }

    }

    public Collection<IRoom> getAllRooms()
    {
        return reservationService.getRoomList();
    }

    public Collection<Customer>getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations()
    {
        reservationService.printAllReservation();
    }



}
