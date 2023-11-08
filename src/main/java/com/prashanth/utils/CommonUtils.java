package com.prashanth.utils;

import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommonUtils {

    private JwtTokenUtil jwtTokenUtil;

    public boolean validateToken(String token) {
        if (token == null) {
            throw JWTException.builder().errorCode("TOKEN_MISSING").errorMessage("The token is missing").status(401).build();

        } else {
            String tokenValue = token.substring(7);
            String isTokenValid = jwtTokenUtil.validateToken(tokenValue);
            if (isTokenValid.equalsIgnoreCase("valid")) {
                return true;
            }
            else if(isTokenValid.equalsIgnoreCase("expired token"))
            {
                throw JWTException.builder()
                        .errorCode("TOKEN_EXPIRED")
                        .errorMessage("The token is expired")
                        .status(401).build();
            }
            else if(isTokenValid.equalsIgnoreCase("invalid token"))
            {
                throw JWTException.builder()
                        .errorCode("TOKEN_INVALID")
                        .errorMessage("The token is invalid")
                        .status(401).build();
            }
            return false;
        }
    }

    public static boolean isNullOrEmpty(Object... objects) {
        for (Object o : objects) {
            if (o == null || o == "") {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(Object... objects) {
        for (Object o : objects) {
            if (o == null || o == "") {
                return false;
            }
        }
        return true;
    }


}
