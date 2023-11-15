package com.prashanth.service.creditservice;

import com.prashanth.model.credit.CreditResponse;
import com.prashanth.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CreditProcessor {

    CreditResponse credit(int id, String token);
    List<CreditResponse> getAllCustomerCredit(String token);
    Optional<CreditResponse> getCustomerCreditById(int id, String token);
    String deleteCustomerCredit(int id,String token);
}

