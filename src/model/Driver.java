package model;

import service.CustomerService;
import view.AdminMenu;
import view.MainMenu;

public class Driver
{
    public static void main(String[] args)
    {
//        Customer customer = new Customer("Yuli","Folborg","yuli@email.com");
//        System.out.println(customer);

        CustomerService cService = new CustomerService();
        cService.addCustomer("yuli@email.com","Yuli","Folborg");
        cService.addCustomer("tiger@cat.com" , "Tiger", "Folborg");
        System.out.println("GET CUSTOMER" + cService.getCustomer("tiger@cat.com"));

        System.out.println(cService.getCustomer("yuli@email.com"));
        System.out.println("ALL CUSTOMERS " + cService.getAllCustomers());

        AdminMenu adminMenu = new AdminMenu();
        //MainMenu mainMenu = new MainMenu();
    }
}
