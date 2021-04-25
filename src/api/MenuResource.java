package api;

import model.Room;
import model.RoomType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuResource
{
    Scanner input = new Scanner(System.in);
    String roomNumInput;
    double roomPriceInput;
    int roomTypeInput;

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
        boolean validEntry;
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


    public int userRoomTypeInput()
    {
        try
        {
            System.out.println("Enter room type: 1 for single bed, 2 for double bed");
            int roomTypeInput;
            roomTypeInput = input.nextInt();

        }catch(InputMismatchException e)
        {
        }
       return roomTypeInput;
    }






}
