package com.prashanth.service.jwtservice;

import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.model.apppropertiesconfig.JwtConfigValues;
import com.prashanth.model.token.JWTTokenResponse;
import com.prashanth.utils.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.prashanth.exceptionhandler.CreditErrorCode.CLIENT_CREDENTIALS_INVALID;

@Service
@Slf4j
@AllArgsConstructor
public class JWTProcessorImpl implements JWTProcessor {

    private JwtTokenUtil jwtTokenUtil;
    private JwtConfigValues jwtConfigValues;

    @Override
    public JWTTokenResponse generateToken(String clientId, String clientSecret, String traceId) {
        String jwtClientId = jwtConfigValues.getClientId();
        String jwtClientSecret = jwtConfigValues.getClientSecret();
        if (clientId.equals(jwtClientId) && clientSecret.equals(jwtClientSecret)) {
            String token = jwtTokenUtil.generateToken(clientId);
            JWTTokenResponse jwtTokenResponse = new JWTTokenResponse();
            jwtTokenResponse.setTokenType("Bearer");
            jwtTokenResponse.setToken(token);
            jwtTokenResponse.setExpirationTime("60000 milliseconds");
            return jwtTokenResponse;

        } else {
            throw JWTException.builder()
                    .errorCode(CLIENT_CREDENTIALS_INVALID.errorCode)
                    .errorMessage(CLIENT_CREDENTIALS_INVALID.errorMessage)
                    .status(CLIENT_CREDENTIALS_INVALID.httpStatus).build();
        }
    }
}
