package com.UMS.FeeService.exception;

public class InvalidFeeException extends RuntimeException {
    public InvalidFeeException(String message) {
        super(message);
    }
}
