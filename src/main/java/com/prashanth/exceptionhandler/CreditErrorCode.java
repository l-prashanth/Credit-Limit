package com.prashanth.exceptionhandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CreditErrorCode {

    TOKEN_EXPIRED("TOKEN_EXPIRED","The token is expired",401),
    TOKEN_INVALID("TOKEN_INVALID","The token is invalid",401),
    TOKEN_MISSING("TOKEN_MISSING","The token is missing",401),
    CLIENT_CREDENTIALS_INVALID("INVALID_CLIENT_CREDENTIALS","Client Id/ Client Secret invalid",401);

    public final String errorCode;
    public final String errorMessage;
    public final int httpStatus;

}
