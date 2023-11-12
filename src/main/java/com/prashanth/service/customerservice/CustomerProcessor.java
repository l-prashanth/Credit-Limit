package com.prashanth.service.customerservice;

import com.prashanth.model.customer.Customer;

public interface CustomerProcessor {

    String appendCustomer(Customer customer,String token);
}
