package com.prashanth.configuration;

import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CreditRepository;
import com.prashanth.service.customerservice.CustomerProcessorImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitDatabase {

    private CustomerProcessorImpl customerProcessorImpl;
    private CreditRepository creditRepository;

    @Bean
    CommandLineRunner initDatabases(){
        return args -> {
            Customer customer = new Customer();
            customer1Data(customer);
            customer2Data(customer);
            customer3Data(customer);
            log.info("Database Initialized");
        };
    }

    public void customer1Data(Customer customer){
        customer.setCustomerId(1);
        customer.setName("Rem");
        customer.setAge(25);
        customer.setCreditScore(876);
        customer.setSalary(450000);
        customer.setExistingCustomer(true);
        creditRepository.save(customer);
//        customerProcessorImpl.appendCustomer(customer);

    }
    public void customer2Data(Customer customer){
        customer.setCustomerId(2);
        customer.setName("Ram");
        customer.setAge(25);
        customer.setCreditScore(634);
        customer.setSalary(325000);
        customer.setExistingCustomer(true);
        creditRepository.save(customer);

//        customerProcessorImpl.appendCustomer(customer,);
    }
    public void customer3Data(Customer customer){
        customer.setCustomerId(3);
        customer.setName("Prashanth");
        customer.setAge(24);
        customer.setCreditScore(830);
        customer.setSalary(1500000);
        customer.setExistingCustomer(true);
        creditRepository.save(customer);

//        customerProcessorImpl.appendCustomer(customer);
    }
}
