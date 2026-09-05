package com.UMS.TimetableService.dto;

import lombok.Data;

@Data
public class DepartmentResponseDTO {
    private Long departmentId;

    private String departmentName;

    private String departmentCode;

    private String description;

    private String status;
}
