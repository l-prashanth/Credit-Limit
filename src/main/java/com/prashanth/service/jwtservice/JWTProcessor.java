package com.prashanth.service.jwtservice;

import com.prashanth.model.token.JWTTokenResponse;

public interface JWTProcessor {

    JWTTokenResponse generateToken(String clientId,String clientSecret,String traceId);
}
