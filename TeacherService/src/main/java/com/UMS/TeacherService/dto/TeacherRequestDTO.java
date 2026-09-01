package com.UMS.TeacherService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeacherRequestDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String mobile;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private String qualification;

    private String specialization;

    private LocalDate joiningDate;

    private Long departmentId;

    private Long roleId;
}
