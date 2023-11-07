package com.prashanth.exceptionhandler.exceptionhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditException {
    String errorCode;
    String errorMessage;
    String traceId;
    int status;
}
