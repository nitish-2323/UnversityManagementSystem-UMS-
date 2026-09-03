package com.UMS.EnrollementService.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
}
