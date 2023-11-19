package com.prashanth.service.creditservice;

import com.prashanth.model.credit.CreditResponse;
import java.util.List;

public interface CreditProcessor {

    CreditResponse credit(int id, String token);
    List<CreditResponse> getAllCustomerCredit(String token);
    CreditResponse getCustomerCreditById(int id, String token);
    String deleteCustomerCredit(int id,String token);
}

