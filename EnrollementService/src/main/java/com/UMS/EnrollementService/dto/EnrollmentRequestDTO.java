package com.UMS.EnrollementService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentRequestDTO {

    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;
    private String semester;
    private String status;
}
