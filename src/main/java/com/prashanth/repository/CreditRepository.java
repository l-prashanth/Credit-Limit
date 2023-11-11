package com.prashanth.repository;

import com.prashanth.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepository extends MongoRepository<Customer, Integer> {
}
