package com.prashanth.exceptionhandler.exceptionhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JWTException extends RuntimeException {
    final String errorCode;
    final String errorMessage;
    final String traceId;
    final int status;
}
