package com.prashanth.exceptionhandler;

import com.prashanth.exceptionhandler.exceptionhandler.CreditException;
import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.model.trace.TraceIdScope;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
@AllArgsConstructor
@Configuration
public class GlobalExceptionHandler {

    TraceIdScope traceIdScope;

    @ExceptionHandler(JWTException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Errors jwtException(JWTException jwtException) {
        return wrapErrorMessages(jwtException.getErrorCode(), jwtException.getErrorMessage(),traceIdScope.getTraceId(), jwtException.getStatus());
    }

    @ExceptionHandler(CreditException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Errors creditException(CreditException creditException) {
        return wrapErrorMessages(creditException.getErrorCode(), creditException.getErrorMessage(),traceIdScope.getTraceId(), creditException.getStatus());
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
