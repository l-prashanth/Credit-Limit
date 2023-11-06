package com.prashanth.service.jwtservice;

import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.model.token.JWTTokenResponse;
import com.prashanth.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JWTProcessorImpl implements JWTProcessor{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public JWTTokenResponse generateToken(String clientId, String clientSecret,String traceId) {
        if (clientId.equals("USER") && clientSecret.equals("*abc")) {
            String token = jwtTokenUtil.generateToken(clientId);
            JWTTokenResponse jwtTokenResponse = new JWTTokenResponse();
            jwtTokenResponse.setToken(token);
            jwtTokenResponse.setExpirationTime("60 seconds");
            log.info("jwtRes>> " + jwtTokenResponse.getToken());
            log.info("jwtRes>> " + jwtTokenResponse);
            return jwtTokenResponse;

        }
        else{
            throw JWTException.builder().errorCode("INVALID_TOKEN").errorMessage("The token is Invalid").traceId(traceId).status(401).build();
        }
    }


}
