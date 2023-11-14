package com.prashanth.service.creditservice;

import com.prashanth.model.apppropertiesconfig.JwtConfigValues;
import com.prashanth.model.customer.Customer;
import com.prashanth.service.customerservice.CustomerProcessorImpl;
import com.prashanth.utils.CommonUtils;
import com.prashanth.utils.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CreditProcessorImpl implements CreditProcessor {

    private CommonUtils commonUtils;
    private CustomerProcessorImpl customerProcessor;


    @Override
    public String credit(int id,String token) {
        commonUtils.validateToken(token);
        if( customerProcessor.getCustomerById(id,token).isPresent()){
            Customer customer = customerProcessor.getCustomerById(id,token).get();
            int customerId = customer.getCustomerId();
        String name =customer.getName();
        int age = customer.getAge();
        int creditScore =customer.getCreditScore();
        long salary =customer.getSalary();
        boolean existingCustomer =customer.isExistingCustomer();
        }



//        {
//            "customerId": 6,
//                "name": "Shakthi",
//                "age": 22,
//                "creditScore": 611,
//                "salary": 150000,
//                "existingCustomer": false
//        }
//        int customerId = customer.getCustomerId();
//        String name =customerId.;
//        int age = ;
//        int creditScore =;
//        int existingCustomer =;
        return "Credit Logic";
    }
}
