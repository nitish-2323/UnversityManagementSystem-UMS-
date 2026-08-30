package com.UMS.StudentService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequestDTO {
    private String firstName;

    private String lastName;

    private String mobile;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;
}

