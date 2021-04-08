package service;

import model.Customer;

import java.util.*;

public class CustomerService
{
    Collection<Customer> customerSet = new HashSet<Customer>();
    Map<String, Customer> mapOfPeople = new HashMap<String,Customer>();
    public static final CustomerService customerService = new CustomerService();


    public void addCustomer(String email, String firstName, String lastName)
    {
        Customer customer = new Customer(firstName,lastName,email);
        customerSet.add(customer);
        mapOfPeople.put(customer.getEmail(),customer);
    }

    public Customer getCustomer(String customerEmail)
    {

        return mapOfPeople.get(customerEmail);
                //map key/val
    }

    public Collection<Customer>getAllCustomers()
    {
        for(Customer customer: customerSet)
        {
            System.out.println(customer);

        }
        return customerSet;
    }



}
