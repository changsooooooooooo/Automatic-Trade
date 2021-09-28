package com.automatictrade.exceptions;

public class ServiceLogicException extends RuntimeException{

    public ServiceLogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
