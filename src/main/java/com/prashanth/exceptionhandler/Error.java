package com.prashanth.exceptionhandler;

import lombok.*;

@Data
@Builder
public class Error {

    public final String code;
    public final String message;
    public final String traceId;
    public final Integer status;
}
