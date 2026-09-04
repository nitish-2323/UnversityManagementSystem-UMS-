package com.UMS.AttendanceService.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private Long studentId;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String status;
}
