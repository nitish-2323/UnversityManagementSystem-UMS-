package com.UMS.AdminService.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequestDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String mobile;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private Long departmentId;

    private Long roleId;

    private String status;
}
