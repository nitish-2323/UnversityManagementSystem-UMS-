package com.UMS.DepartmentService.Execption;

public class DepartmentIdNotFound extends RuntimeException {
    public DepartmentIdNotFound(String message) {
        super(message);
    }
}
