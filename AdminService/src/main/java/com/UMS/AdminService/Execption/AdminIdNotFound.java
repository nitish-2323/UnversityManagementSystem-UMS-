package com.UMS.AdminService.Execption;

public class AdminIdNotFound extends RuntimeException {
    public AdminIdNotFound(String message) {
        super(message);
    }
}
