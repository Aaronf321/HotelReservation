package service;

import model.Customer;

import java.util.*;

public class CustomerService
{
    private static  CustomerService customerService = null;
    Collection<Customer> customerList = new ArrayList<>();
  //  Map<String, Customer> mapOfPeople = new HashMap<String,Customer>();


    public static CustomerService getInstance()
    {
        if(null == customerService)
        {
           customerService = new CustomerService();
        }
        return customerService;
    }



    public void addCustomer(String email, String firstName, String lastName)
    {
        Customer customer = new Customer(firstName,lastName,email);
        customerList.add(customer);

    }

    public Customer getCustomer(String customerEmail)
    {
        for(Customer customers:customerList)
        {
            if(customers.getEmail().equals(customerEmail))
            {
                return customers;
            }
        }
        return null;

    }

    public Collection<Customer>getAllCustomers()
    {
        for(Customer customer: customerList)
        {
            System.out.println(customer);

        }
        return customerList;
    }



}
