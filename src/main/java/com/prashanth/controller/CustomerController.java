package com.prashanth.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prashanth.configuration.InsertingMultipleDocuments;
import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CreditRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.bson.Document;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credit")
@AllArgsConstructor
public class CustomerController {

    private CreditRepository repository;
    private InsertingMultipleDocuments insertingMultipleDocuments;

    @SneakyThrows
    @PostMapping("addCustomer")
    public String saveBook(@RequestBody Customer customer) {
//        insertingMultipleDocuments.insertmultipledocs();
//        List<Document> list = new ArrayList<Document>();
//        list.add(document1);
//        list.add(document2);
//        list.add(document3);
        repository.save(customer);
        return "Added book with id : " + customer.getId();
    }

    @SneakyThrows
    @PostMapping("addCustomer1")
    public String saveBook() {
        insertingMultipleDocuments.insertmultipledocs();
//        List<Document> list = new ArrayList<Document>();
//        list.add(document1);
//        list.add(document2);
//        list.add(document3);
//        repository.save(customer);
        return "Added book with id : ";
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
