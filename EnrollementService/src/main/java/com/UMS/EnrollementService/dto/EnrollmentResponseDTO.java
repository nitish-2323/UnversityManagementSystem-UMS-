package com.UMS.EnrollementService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentResponseDTO {
    private Long enrollmentId;
    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;
    private String semester;
    private String status;
    private StudentResponseDTO studentResponseDTO;
    private  CourseResponseDTO courseResponseDTO;
}
