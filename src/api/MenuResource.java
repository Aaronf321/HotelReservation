package api;

import model.Room;
import model.RoomType;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuResource
{
    Scanner input = new Scanner(System.in);
    String roomNumInput;
    double roomPriceInput;
    String firstNameInput;
    String lastNameInput;
    String emailInput;
    boolean validEntry;

    public MenuResource()
    {

    }


    public String userRoomNumInput()
    {
        try {
            System.out.println("Enter room number: ");
            roomNumInput = input.next();

        }catch (IllegalArgumentException e)
        {
            System.out.println("Invalid Entry");
            userRoomNumInput();
        }
        return roomNumInput;
    }


    public double userRoomPriceInput()
    {

        do {
            try {
                System.out.println("Enter price per night: ");
                roomPriceInput = input.nextInt();
                validEntry = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry, please enter numbers only.");
                validEntry = false;
                input.nextLine();
            }
        } while(!validEntry);
      return roomPriceInput;
    }

    public String userFirstNameInput()
    {

      do {
          try {
              System.out.println("Please enter your first name: ");
              firstNameInput = input.next();
              validEntry = true;
          } catch (InputMismatchException e) {
              System.out.println("Invalid input");
              validEntry = false;
              input.nextLine();
          }
      }while(!validEntry);
        return firstNameInput;
    }

    public String userLastNameInput()
    {
        do {
            try {
                System.out.println("Please enter your last name: ");
                lastNameInput = input.next();
                validEntry = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                validEntry = false;
                input.nextLine();
            }
        }while(!validEntry);
        return lastNameInput;
    }

    public String userEmailInput()
    {


        do {
                try {
                    System.out.println("Please enter you email (format name@domain.com:)");
                    emailInput = input.next();
                    validEntry = true;


                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                    validEntry = false;
                    input.nextLine();
                }

        }while(!validEntry);
        return emailInput;
    }













}
