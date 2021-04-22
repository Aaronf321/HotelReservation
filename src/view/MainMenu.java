package view;


import api.HotelResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu
{
    public static final HotelResource hotelResource = HotelResource.getInstance();
    public static Scanner input = new Scanner(System.in);
    public static Date parsedDate = null;


    public MainMenu()
    {
        System.out.println("1.Find and reserve a room\n2.See my reservations\n3.Create an account\n4.Admin" +
                "\n5.Exit");
        menuSelect();

    }
    public void menuSelect()
    {
        int userInput = input.nextInt();
        Date checkIn;
        Date checkOut;


       switch(userInput)
       {
           case 1: choiceOne();
           break;

           case 2: choiceTwo();
           break;

           case 3: choiceThree();
           break;

           case 4: choiceFour();
           break;

           case 5: System.exit(0);
           break;

           default: String invalid = "Invalid input";
           break;
       }





    }

    public void choiceOne()
    {
        System.out.println("Enter check in date: ");
        Date checkInInput = enterDate();
        System.out.println("Enter check out date: ");
        Date checkOutInput = enterDate();

        hotelResource.findARoom(checkInInput,checkOutInput);
        new MainMenu();
        menuSelect();
    }

    /*
     TEST choiceTwo when you're able
      to add rooms in adminMenu
    */

    public void choiceTwo()
    {

        System.out.println("Please enter your email to check your current reservation: (format: name@domain.com) ");
        String emailInput = input.nextLine();
        hotelResource.getCustomerReservations(emailInput);
        new MainMenu();
        menuSelect();
    }
    public void choiceThree()
    {
        System.out.println("Please enter your first name: ");
        String firstName = input.next();
        System.out.println("Please enter your last name: ");
        String lastName = input.next();
        System.out.println("Please enter you email (format name@domain.com:");
        String email = input.next();

        hotelResource.createACustomer(email,firstName,lastName);
        new MainMenu();
        menuSelect();
    }

    public void choiceFour()
    {
        AdminMenu adminMenu = new AdminMenu();
    }

    private static Date enterDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateInput = input.next();

        try {

            parsedDate = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }


}
