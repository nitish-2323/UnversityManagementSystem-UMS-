package com.UMS.RoleService.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecptionDTO {
    private int status;
    private String msg;
    private LocalDateTime dateTime;
    private String path;
}
