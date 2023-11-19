package com.prashanth.repository;

import com.prashanth.model.credit.CreditResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditRepository extends MongoRepository<CreditResponse, Integer> {

    @Query("{customerId :?0}")      //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
    Optional<CreditResponse> getCustomerCreditById(Integer id);

    @Query(value="{customerId :?0}", delete = true)
    void deleteCustomerCreditById (Integer id);
}
