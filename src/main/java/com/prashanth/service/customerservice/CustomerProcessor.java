package com.prashanth.service.customerservice;

import com.prashanth.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerProcessor {

    String appendCustomer(Customer customer,String token);
    List<Customer> getAllCustomer(String token);
    Optional<Customer> getCustomerById(int id, String token);
    String deleteCustomer(int id,String token);
}
