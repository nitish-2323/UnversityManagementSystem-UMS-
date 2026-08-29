package com.UMS.RoleService.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoleResponseDTO {
    private Long roleId;
    private String roleName;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}
