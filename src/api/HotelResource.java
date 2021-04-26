package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import view.MainMenu;

import java.util.Collection;
import java.util.Date;

public class HotelResource
{
    private static HotelResource hotelResource = null;
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static final CustomerService customerService = CustomerService.getInstance();

    public static HotelResource getInstance()
    {
        if(null == hotelResource)
        {
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }


    public Customer getCustomer(String email)
    {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName,String lastName)
    {
        customerService.addCustomer(email,firstName,lastName);
    }

    public IRoom getRoom(String roomNumber)
    {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate)
    {
        return reservationService.reserveARoom(customerService.getCustomer(customerEmail),room,checkInDate,checkOutDate);
    }

    public Collection<Reservation>getCustomerReservations(String customerEmail)
    {
        if(customerService.getCustomer(customerEmail) == null)
        {
            System.out.println("Sorry, you must first make an account before you can search for your reservation.");
            new MainMenu();
        }
        return reservationService.getCustomerReservation(customerService.getCustomer(customerEmail));

        //return reservationService.getCustomerReservation(reservationService.getReservationList();
    }

    public Collection<IRoom>findARoom(Date checkIn,Date checkOut)
    {
        return reservationService.findRooms(checkIn, checkOut);
    }


}
