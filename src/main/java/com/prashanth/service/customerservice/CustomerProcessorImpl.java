package com.prashanth.service.customerservice;

import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CreditRepository;
import com.prashanth.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerProcessorImpl implements CustomerProcessor{

    private CreditRepository repository;
    private CommonUtils commonUtils;
    @Override
    public String appendCustomer(Customer customer,String token){
        commonUtils.validateToken(token);
        repository.save(customer);
        return "Customer Details added successfully";
    }
}
