package com.prashanth.repository;

import com.prashanth.model.credit.CreditResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepository extends MongoRepository<CreditResponse, Integer> {
}
