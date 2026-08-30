package com.UMS.StudentService.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentResponseDTO {
    private Long studentId;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String mobile;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private Long departmentId;
    private Long roleId;
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

     private DepartmentResponseDTO responseDepartmentDTO;
     private RoleResponseDTO responseRoleDTO;
}
