package view;

import api.AdminResource;
import api.MenuResource;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.ReservationService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu
{

    Scanner input = new Scanner(System.in);
    public static final AdminResource adminResource = AdminResource.getInstance();
    public static final ReservationService reservationService = ReservationService.getInstance();
    MenuResource menuResource = new MenuResource();
    //MainMenu mainMenu = new MainMenu();
    int roomTypeInput;

    public AdminMenu()
    {
        System.out.println("1.See all customers\n2.See all rooms\n3.See all reservations" +
                "\n4.Add a room\n5.Back to main menu");
        adminSelect();
    }

    public void adminSelect()
    {
        int userInput = input.nextInt();

     switch(userInput)
     {
         case 1: viewCustomers();
         break;

         case 2: seeAllRooms();
         break;

         case 3: seeAllReservations();
         break;

         case 4: roomAdd();
         break;

         case 5:  new MainMenu();

         break;
     }



    }
    public void viewCustomers()
    {
        adminResource.getAllCustomers();
        new AdminMenu();
    }


    public void roomAdd()
    {
        List<IRoom> addToList = new ArrayList<>();
//        System.out.println("Enter room number: ");
//        String roomNumber = input.next();

//        System.out.println("Enter price per night: ");
//        double roomPrice = input.nextInt();
        boolean validEntry;
        do {
            try {
                System.out.println("Enter room type: 1 for single bed, 2 for double bed");
                roomTypeInput = input.nextInt();
                validEntry = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please enter '1' for single bed or '2' for double bed");
                validEntry = false;
                input.nextLine();
            }
        }while(!validEntry);


        if(roomTypeInput == 1)
        {
            Room room = new Room(menuResource.userRoomNumInput(),menuResource.userRoomPriceInput(),RoomType.SINGLE);
            addToList.add(room);
            adminResource.addRoom(addToList);
            //AdminResource.adminResource.addRoom((List<IRoom>) room);
        }else if(roomTypeInput == 2)
        {
            Room room = new Room(menuResource.userRoomNumInput(), menuResource.userRoomPriceInput(), RoomType.DOUBLE);
            addToList.add(room);
            adminResource.addRoom(addToList);
        }

        do {
            try {
                System.out.println("Would you like to add another room? y/n");
                String confirmInput = input.next();
                validEntry = true;
                if (confirmInput.equals("y")) {
                    roomAdd();
                } else if (confirmInput.equals("n")) {
                    new AdminMenu();
                }

            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry. Please enter y for yes or n for no");
                validEntry = false;
                input.nextLine();
            }
        }while (validEntry);



    }

    public void seeAllRooms()
    {
        adminResource.getAllRooms();
        new AdminMenu();

    }

    public void seeAllReservations()
    {
        adminResource.displayAllReservations();
    }


}
