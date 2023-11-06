package com.prashanth.exceptionhandler;

import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.model.token.JWTTokenResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
@Configuration
public class GlobalExceptionHandler {



    @ExceptionHandler(JWTException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Errors jwtException(JWTException jwtException) {
        return wrapErrorMessages(jwtException.getErrorCode(), jwtException.getErrorMessage(),jwtException.getTraceId(), jwtException.getStatus());
    }

    private Errors wrapErrorMessagesForJWT(String code, String message, Integer status) {
        return Errors.builder().
                errors(
                        Error.builder()
                                .code(code)
                                .message(message)
                                .status(status).build()
                ).build();

    }
    private Errors wrapErrorMessages(String code, String message, String traceId, Integer status) {
        return Errors.builder().
                errors(
                        Error.builder()
                                .code(code)
                                .message(message)
                                .traceId(traceId)
                                .status(status).build()
                ).build();

    }
}
