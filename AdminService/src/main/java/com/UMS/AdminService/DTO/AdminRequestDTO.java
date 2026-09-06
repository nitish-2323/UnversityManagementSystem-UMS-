package com.UMS.AdminService.DTO;

import lombok.Data;

@Data
public class AdminRequestDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String mobile;

    private Long departmentId;

    private Long roleId;

    private String status;
}
