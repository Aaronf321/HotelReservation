package view;

import api.AdminResource;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.List;
import java.util.Scanner;

public class AdminMenu
{
    Scanner input = new Scanner(System.in);
    public static final ReservationService reservationService = ReservationService.getInstance();
    public AdminMenu()
    {
        System.out.println("1.See all customers\n2.See all rooms\n3.See all reservations" +
                "\n4.Add a room\n5.Back to main menu");
        adminSelect();
    }

    public void adminSelect()
    {
        int userInput = input.nextInt();

        if(userInput == 1)
        {
           CustomerService.customerService.getAllCustomers();
        }else if(userInput == 2)
        {

        }else if(userInput == 3)
        {

        }else if(userInput == 4)
        {
            roomAdd();
        }else if(userInput == 5)
        {
            MainMenu mainMenu = new MainMenu();
        }
    }

    public void roomAdd()
    {
        System.out.println("Enter room number: ");
        String roomNumber = input.next();
        System.out.println("Enter price per night: ");
        double roomPrice = input.nextInt();
        System.out.println("Enter room type: 1 for single bed, 2 for double bed");
        int roomTypeInput = input.nextInt();

        if(roomTypeInput == 1)
        {
            Room room = new Room(roomNumber,roomPrice,RoomType.SINGLE);
            ReservationService.reservationService.roomList.add(room);
            //AdminResource.adminResource.addRoom((List<IRoom>) room);
            ReservationService.reservationService.addRoom(room);
        }else if(roomTypeInput == 2)
        {
            Room room = new Room(roomNumber,roomPrice,RoomType.DOUBLE);
            AdminResource.adminResource.addRoom(ReservationService.reservationService.addRoom(room));
        }


    }


}
