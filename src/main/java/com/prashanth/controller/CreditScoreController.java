package com.prashanth.controller;


import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.model.token.JWTTokenRequest;
import com.prashanth.model.token.JWTTokenResponse;
import com.prashanth.service.creditservice.CreditProcessorImpl;
import com.prashanth.utils.CommonUtils;
import com.prashanth.utils.JwtTokenUtil;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")

public class CreditScoreController {

    @Autowired
    private CreditProcessorImpl creditProcessor;

    @GetMapping("/limit")
    public ResponseEntity<String> welcome(@RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditProcessor.credit(token));
    }
}
