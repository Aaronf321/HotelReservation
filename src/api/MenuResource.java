package api;

import model.IRoom;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuResource
{
    public static Scanner input = new Scanner(System.in);
    public static Date parsedDate = null;
    String roomNumInput;
    double roomPriceInput;
    String firstNameInput;
    String lastNameInput;
    String emailInput;
    static boolean validEntry;
    Date checkInInput;
    Date checkOutInput;
    ReservationService reservationService = ReservationService.getInstance();



    public MenuResource()
    {

    }

//    public static Date getInstance()
//    {
//        if(null == parsedDate)
//        {
//            parsedDate = new Date();
//        }
//        return parsedDate;
//    }
public String userRoomNumInput()
{
    try {
        System.out.println("Enter room number: ");
        roomNumInput = input.next();

    }catch (IllegalArgumentException e)
    {
        System.out.println("Invalid Entry");
    }
    return roomNumInput;
}

    public String userRoomNumChecker()
    {
        do {
            try {
                System.out.println("Enter room number: ");
                roomNumInput = input.next();
                if (userRoomNumChecker(roomNumInput)) {
                    System.out.println("Enter room number: ");
                    roomNumInput = input.next();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Entry");
            }
            return roomNumInput;
        }while(!userRoomNumChecker(roomNumInput));

    }


    public boolean userRoomNumChecker(String roomNumberInput)
    {

                for(IRoom availableRooms: reservationService.getRoomList())
                {
                    if(!availableRooms.getRoomNumber().equals(roomNumberInput))
                    {
                        System.out.println("That room number does not exist.\n" +
                                "please choose a room number from the available list of\n" +
                                "rooms.");
                        return true;

                    }
                }
                return false;
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
    public String emailPatternChecker(String userEmail)
    {
        return userEmail;
    }




    public String userEmailInput()
    {
        System.out.println("Please enter your email (format name@domain.com:)");

        Matcher matcher;
        do {
            emailInput = input.next();
            String regexEmail = "^(.+)@(.+).(.+)$";
            Pattern pattern = Pattern.compile(regexEmail);
            matcher = pattern.matcher(this.emailInput);
            if (!matcher.find()) {
                System.out.println("Email does not match correct format. . .");
                validEntry = false;
            }else
            {
                validEntry = true;
            }
        }while(!validEntry);


        return emailInput;
    }


    public static Date enterDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        do {
            try {
                String dateInput = input.next();
                parsedDate = dateFormat.parse(dateInput);
                validEntry = true;
            } catch (ParseException e) {
                System.out.println("Invalid entry use format (mm/dd/yyyy)");
                validEntry = false;
            }
        }while(!validEntry);

        return parsedDate;
    }


    public String getRoomNumInput() {
        return roomNumInput;
    }
}


