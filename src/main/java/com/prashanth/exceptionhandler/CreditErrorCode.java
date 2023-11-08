package com.prashanth.exceptionhandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CreditErrorCode {

    TOKEN_EXPIRED("","",401),
    CLIENT_CREDENTIALS_INVALID("INVALID_CLIENT_CREDENTIALS","Client Id/ Client Secret invalid",401);

    public final String errorCode;
    public final String errorMessage;
    public final int httpStatus;

}
