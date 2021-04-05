package view;

import api.HotelResource;
import model.Customer;
import service.CustomerService;

import java.util.Scanner;

public class MainMenu
{
    Scanner input = new Scanner(System.in);
    public MainMenu()
    {
        System.out.println("1.Find and reserve a room\n2.See my reservations\n3.Create an account\n4.Admin" +
                "\n5.Exit");
        menuSelect();

    }
    public void menuSelect()
    {
        int userInput = input.nextInt();

        if(userInput == 1)
        {

        }else if(userInput == 2)
        {

        }else if(userInput == 3)
        {
            choiceThree();
        }else if(userInput == 4)
        {
            choiceFour();
        }else if(userInput == 5)
        {
            System.exit(0);
        }

    }


    public void choiceThree()
    {
        System.out.println("Please enter your first name: ");
        String firstName = input.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = input.nextLine();
        System.out.println("Please enter you email:");
        String email = input.nextLine();

        HotelResource.hotelResource.createACustomer(email,firstName,lastName);
    }

    public void choiceFour()
    {
        AdminMenu adminMenu = new AdminMenu();
    }

}
