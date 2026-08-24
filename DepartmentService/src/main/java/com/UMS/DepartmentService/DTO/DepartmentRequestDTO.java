package com.UMS.DepartmentService.DTO;

import lombok.Data;

@Data
public class DepartmentRequestDTO {
    private String departmentCode;
    private String departmentName;
    private String description;
    private String hodName;
    private String email;
    private String phone;
}
