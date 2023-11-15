package com.prashanth.exceptionhandler.exceptionhandler;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class JWTException extends RuntimeException {
    final String errorCode;
    final String errorMessage;
    final String traceId;
    final int status;
}
