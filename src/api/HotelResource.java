package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;

import java.util.Collection;
import java.util.Date;

public class HotelResource
{
    public static final HotelResource hotelResource = new HotelResource();

    public Customer getCustomer(String email)
    {
        return CustomerService.customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName,String lastName)
    {
        CustomerService.customerService.addCustomer(email,firstName,lastName);
    }
//
//    public IRoom getRoom(String roomNumber)
//    {
//        return
//    }
//
//    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate)
//    {
//        return
//    }
//
//    public Collection<Reservation>getCustomerReservations(String customerEmail)
//    {
//        return
//    }
//
//    public Collection<IRoom>findARoom(Date checkIn,Date checkOut)
//    {
//        return
//    }


}
