package com.prashanth.utils;

import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.prashanth.exceptionhandler.CreditErrorCode.*;

@Component
@AllArgsConstructor
public class CommonUtils {

    private JwtTokenUtil jwtTokenUtil;

    public boolean validateToken(String token) {
        if (CommonUtils.isNotNullOrEmpty(token)) {
            String tokenValue = token.substring(7);
            String isTokenValid = jwtTokenUtil.validateToken(tokenValue);
            if (isTokenValid.equalsIgnoreCase("valid")) {
                return true;
            } else if (isTokenValid.equalsIgnoreCase("expired token")) {
                throw JWTException.builder()
                        .errorCode(TOKEN_EXPIRED.errorCode)
                        .errorMessage(TOKEN_EXPIRED.errorMessage)
                        .status(TOKEN_EXPIRED.httpStatus).build();
            } else if (isTokenValid.equalsIgnoreCase("invalid token")) {
                throw JWTException.builder()
                        .errorCode(TOKEN_INVALID.errorCode)
                        .errorMessage(TOKEN_INVALID.errorMessage)
                        .status(TOKEN_INVALID.httpStatus).build();
            }
        }
        throw JWTException.builder()
                .errorCode(TOKEN_MISSING.errorCode)
                .errorMessage(TOKEN_MISSING.errorMessage)
                .status(TOKEN_MISSING.httpStatus).build();
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
