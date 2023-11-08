package com.prashanth.controller;

import com.prashanth.service.creditservice.CreditProcessorImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
@AllArgsConstructor
public class CreditScoreController {

    private CreditProcessorImpl creditProcessor;

    @GetMapping("/limit")
    public ResponseEntity<String> welcome(@RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditProcessor.credit(token));
    }
}
