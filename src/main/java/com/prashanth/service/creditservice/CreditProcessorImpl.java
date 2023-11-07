package com.prashanth.service.creditservice;

import com.prashanth.exceptionhandler.exceptionhandler.CreditException;
import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditProcessorImpl implements CreditProcessor{

    @Autowired
    private CommonUtils commonUtils;
    @Override
    public String credit(String token) {
        commonUtils.validateToken(token);
//        if (commonUtils.isValidToken(token)) {
            return "Credit Logic";
//        }
//        else {
//            throw JWTException.builder().errorCode("TOKEN_INVALID").errorMessage("The token is invalid").status(401).build();
//        }
    }
}
