package com.prashanth.exceptionhandler;

import lombok.*;

@Data
@Builder
public class Error {

    public String code;
    public String message;
    public String traceId;
    public Integer status;
}
