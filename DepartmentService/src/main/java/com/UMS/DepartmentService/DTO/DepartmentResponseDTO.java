package com.UMS.DepartmentService.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartmentResponseDTO {
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private String description;
    private String hodName;
    private String email;
    private String phone;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
