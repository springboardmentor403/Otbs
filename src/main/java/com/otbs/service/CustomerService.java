package com.otbs.service;

import com.otbs.model.Customer;
import com.otbs.repository.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        Customer registeredCustomer = customerRepository.save(customer);
        System.out.println("Customer registered and email sent to: " + registeredCustomer.getEmail());
        return registeredCustomer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer authenticate(String username, String password) {
        Customer customer = customerRepository.findByUsernameAndPassword(username, password);
        if (customer != null) {
            return customer;
        }
        return null;
    }
    
    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    // Update Customer Details
    public Customer updateCustomer(String username, Customer customer) {
        // Fetch the existing customer directly
        Customer existingCustomer = customerRepository.findByUsername(username);

        if (existingCustomer != null) {
            // Update only the fields that are allowed to change
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setDob(customer.getDob());
            existingCustomer.setGender(customer.getGender());

            // Save and return the updated customer
            return customerRepository.save(existingCustomer);
        } else {
            // Handle the case where the customer is not found
            throw new RuntimeException("Customer not found with username: " + username);
        }
    }
}

