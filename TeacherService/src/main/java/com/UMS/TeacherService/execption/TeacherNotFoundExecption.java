package com.UMS.TeacherService.execption;

public class TeacherNotFoundExecption extends RuntimeException {
    public TeacherNotFoundExecption(String message) {
        super(message);
    }
}
