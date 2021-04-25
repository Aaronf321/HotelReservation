package view;


import api.HotelResource;
import api.MenuResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu
{
    public static final HotelResource hotelResource = HotelResource.getInstance();
    public static Scanner input = new Scanner(System.in);
    public static Date parsedDate = null;
    public MenuResource menuResource = new MenuResource();
    AdminMenu adminMenu;


    public MainMenu()
    {
        System.out.println("1.Find and reserve a room\n2.See my reservations\n3.Create an account\n4.Admin" +
                "\n5.Exit");
        menuSelect();

    }
    public void menuSelect()
    {
        int userInput = input.nextInt();



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


        //SOMETHING GOES HERE


        System.out.println("Please enter your email (format: email@domain.com)");
        String emailInput = input.next();
        System.out.println("Please enter room number");
        String roomInput = input.next();


        hotelResource.findARoom(checkInInput,checkOutInput);
        hotelResource.bookARoom(emailInput, hotelResource.getRoom(roomInput),checkInInput,checkOutInput);
        new MainMenu();

    }

    /*
     TEST choiceTwo when you're able
      to add rooms in adminMenu
    */

    public void choiceTwo()
    {
        menuResource.userEmailInput();
        new MainMenu();
    }
    public void choiceThree()
    {
            hotelResource.createACustomer(menuResource.userEmailInput(),menuResource.userFirstNameInput(), menuResource.userLastNameInput());
            new MainMenu();
            menuSelect();

    }

    public void choiceFour()
    {
        new AdminMenu();
    }

    private static Date enterDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        try {
            String dateInput = input.next();
            parsedDate = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }


}
