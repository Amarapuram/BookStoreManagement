package com.CustomerService.service;

import com.CustomerService.exceptions.CustomerNotFoundException;
import com.CustomerService.exceptions.DuplicateCustomerException;
import com.CustomerService.model.Customer;
import com.CustomerService.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerBYId(String id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional;
        } else {
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }
    }

    public Customer saveCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            throw new DuplicateCustomerException("Customer with id " + customer.getId() + " already exists");
        }
        return customerRepository.save(customer);
    }


    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }
}
