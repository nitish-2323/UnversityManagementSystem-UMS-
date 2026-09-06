package com.UMS.AdminService.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminResponseDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String mobile;

    private Long departmentId;

    private Long roleId;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    private RoleResponseDTO roleResponseDTO;
    private DepartmentResponseDTO departmentResponseDTO;
}
