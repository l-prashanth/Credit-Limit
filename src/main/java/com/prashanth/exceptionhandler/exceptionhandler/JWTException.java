package com.prashanth.exceptionhandler.exceptionhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JWTException extends RuntimeException {
    String errorCode;
    String errorMessage;
    int status;
}
