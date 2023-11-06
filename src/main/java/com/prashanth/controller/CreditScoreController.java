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

//    @PostMapping("/generate-token")
//    public ResponseEntity<Object> generateToken(@RequestBody JWTTokenRequest jwtTokenRequest){
//        String jwtUsername=jwtTokenRequest.getClientId();
//        String jwtPassword=jwtTokenRequest.getClientSecret();
//        if(jwtUsername.equals("USER") && jwtPassword.equals("*abc")){
//            String token = jwtTokenUtil.generateToken(jwtUsername);
//            JWTTokenResponse jwtTokenResponse = new JWTTokenResponse();
//            jwtTokenResponse.setToken(token);
//            jwtTokenResponse.setExpirationTime("60 seconds");
//            return ResponseEntity.ok(jwtTokenResponse);
//        }else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
//        }
//    }
//
//    @PostMapping("/validate-token")
//    public ResponseEntity<Object> validateToken(@RequestBody JWTTokenResponse jwtTokenResponse){
//        return ResponseEntity.ok(jwtTokenUtil.validateToken(jwtTokenResponse.getToken()));
//    }


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
