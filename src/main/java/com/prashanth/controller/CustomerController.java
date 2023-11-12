package com.prashanth.controller;

import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CreditRepository;
import com.prashanth.service.customerservice.CustomerProcessorImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credit")
@AllArgsConstructor
public class CustomerController {

    private CreditRepository repository;
    private CustomerProcessorImpl customerProcessorImpl;

    @SneakyThrows
    @PostMapping("addCustomer")
    public ResponseEntity<String> saveBook(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerProcessorImpl.appendCustomer(customer,token));
    }

    @GetMapping("/findAllCustomer")
    public List<Customer> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/findAllCustomer/{id}")
    public Optional<Customer> getBook(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "book deleted with id : " + id;
    }

}
