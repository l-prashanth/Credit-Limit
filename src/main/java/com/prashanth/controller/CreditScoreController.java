package com.prashanth.controller;

import com.prashanth.model.credit.CreditRequest;
import com.prashanth.model.credit.CreditResponse;
import com.prashanth.service.creditservice.CreditProcessorImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credit")
@AllArgsConstructor
public class CreditScoreController {

    private CreditProcessorImpl creditProcessor;

    @PostMapping("/limit")
    public ResponseEntity<String> creditLimit(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody CreditRequest creditRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditProcessor.credit(creditRequest.getId(),token));
    }

    @GetMapping("/findAllCustomerCredit")
    public ResponseEntity<List<CreditResponse>> getAllCustomerCredit(@RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.OK).body(creditProcessor.getAllCustomerCredit(token));
    }

    @GetMapping("/findAllCustomerCredit/{id}")
    public ResponseEntity<CreditResponse> getCustomerCreditById(
            @PathVariable int id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.OK).body(creditProcessor.getCustomerCreditById(id,token));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerCredit(
            @PathVariable int id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.OK).body(creditProcessor.deleteCustomerCredit(id, token));
    }
}
