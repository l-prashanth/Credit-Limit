package com.prashanth.controller;


import com.prashanth.model.token.JWTTokenRequest;
import com.prashanth.model.token.JWTTokenResponse;
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
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/limit")
    public  ResponseEntity<?> welcome(@RequestHeader(value = "Authorization",required = false) String token) {
        if (token == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized. Token is required");
        }else{
            String tokenValue = token.substring(7);
            String isTokenValid = jwtTokenUtil.validateToken(tokenValue);
            if (isTokenValid.equalsIgnoreCase("valid")){
                return new ResponseEntity<>("credit logic", HttpStatus.OK);
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized due to: " + isTokenValid);
            }
        }
    }
}
