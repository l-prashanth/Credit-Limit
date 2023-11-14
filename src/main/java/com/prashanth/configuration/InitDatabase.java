package com.prashanth.configuration;

import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitDatabase {

    private CustomerRepository customerRepository;

    @Bean
    CommandLineRunner initDatabases(){
        return args -> {
            Customer customer = new Customer();
            customer1Data(customer);
            customer2Data(customer);
            customer3Data(customer);
            customer4Data(customer);
            customer5Data(customer);
            log.info("Database Initialized");
        };
    }

    public void customer1Data(Customer customer){
        customer.setCustomerId(1);
        customer.setName("Rem");
        customer.setAge(19);
        customer.setCreditScore(876);
        customer.setSalary(450000);
        customer.setExistingCustomer(true);
        customerRepository.save(customer);
    }
    public void customer2Data(Customer customer){
        customer.setCustomerId(2);
        customer.setName("Ram");
        customer.setAge(19);
        customer.setCreditScore(634);
        customer.setSalary(325000);
        customer.setExistingCustomer(false);
        customerRepository.save(customer);
    }
    public void customer3Data(Customer customer){
        customer.setCustomerId(3);
        customer.setName("Prashanth");
        customer.setAge(24);
        customer.setCreditScore(830);
        customer.setSalary(1500000);
        customer.setExistingCustomer(true);
        customerRepository.save(customer);
    }
    public void customer4Data(Customer customer){
        customer.setCustomerId(4);
        customer.setName("Leo");
        customer.setAge(38);
        customer.setCreditScore(710);
        customer.setSalary(1000000);
        customer.setExistingCustomer(false);
        customerRepository.save(customer);
    }
    public void customer5Data(Customer customer){
        customer.setCustomerId(5);
        customer.setName("Pawan");
        customer.setAge(34);
        customer.setCreditScore(816);
        customer.setSalary(1200000);
        customer.setExistingCustomer(false);
        customerRepository.save(customer);
    }
}
