package com.prashanth.service.customerservice;

import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CustomerRepository;
import com.prashanth.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerProcessorImpl implements CustomerProcessor{

    private CustomerRepository repository;
    private CommonUtils commonUtils;
    @Override
    public String appendCustomer(Customer customer,String token){
        commonUtils.validateToken(token);
        repository.save(customer);
        return "Customer Details added successfully";
    }

    @Override
    public List<Customer> getAllCustomer(String token) {
        commonUtils.validateToken(token);
        return repository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int id, String token) {
        commonUtils.validateToken(token);
        return repository.findById(id);
    }

    @Override
    public String deleteCustomer(int id, String token) {
        commonUtils.validateToken(token);
        repository.deleteById(id);
        return "Customer deleted successfully";
    }
}
