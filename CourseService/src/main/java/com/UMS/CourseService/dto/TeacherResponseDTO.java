package com.UMS.CourseService.dto;

import lombok.Data;

@Data
public class TeacherResponseDTO {
    private Long teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
}
