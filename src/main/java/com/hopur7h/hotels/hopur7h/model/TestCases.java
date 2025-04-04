package com.hopur7h.hotels.hopur7h.model;

import com.hopur7h.hotels.hopur7h.controller.CustomerController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Nafn : Þorsteinn H. Erlendsson
 * Tölvupóstur: the85@hi.is
 * Lýsing: Later
 **/
public class TestCases {

    private CustomerController customerController;
    private Customer customer;


    @BeforeEach // sets up ojects before every test
    public void setUp() {
        customerController = new CustomerController();
        customer = new Customer("username", "realName", "password", "email", "phoneNumber");
    }

    @AfterEach  // reset after each test
    public void tearDown() {
        customerController = null;
        customer = null;
    }

    @Test   // test adding a costumer
    public void testAddCustomer() {
        customerController.addCustomer(customer);
        Customer testCustomer = customerController.getCustomer(customer.getUsername());
        assertEquals(customer, testCustomer);
    }

    @Test  // test removing a costumer
    public void testRemoveCustomer() {
        //add customer from fresh plate (assumes previous test works and input customerController is empty)
        customerController.addCustomer(customer);
        Customer testCustomer = customerController.getCustomer(customer.getUsername());

        //Removes based on previous getcustomer
        customerController.removeCustomer(testCustomer.getUsername());
        List<Customer> listCustomers = customerController.getAllCustomers();
        assertTrue(listCustomers.isEmpty());

    }

}
