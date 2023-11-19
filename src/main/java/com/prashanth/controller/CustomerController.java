package com.prashanth.controller;

import com.prashanth.model.customer.Customer;
import com.prashanth.service.customerservice.CustomerProcessorImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerProcessorImpl customerProcessorImpl;

    @SneakyThrows
    @PostMapping("addCustomer")
    public ResponseEntity<String> saveCustomer(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerProcessorImpl.appendCustomer(customer, token));
    }

    @GetMapping("/findAllCustomer")
    public ResponseEntity<List<Customer>> getCustomer(@RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerProcessorImpl.getAllCustomer(token));
    }

    @GetMapping("/findAllCustomer/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(
            @PathVariable int id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerProcessorImpl.getCustomerById(id,token));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(
            @PathVariable int id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerProcessorImpl.deleteCustomer(id, token));
    }
}
