package com.UMS.TeacherService.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TeacherResponseDTO {
    private Long teacherId;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String mobile;

    private String qualification;

    private String specialization;

    private LocalDate joiningDate;

    private Long departmentId;

    private Long roleId;

    private String status;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private DepartmentResponseDTO responseDepartmentDTO;

    private RoleResponseDTO responseRoleDTO;
}
