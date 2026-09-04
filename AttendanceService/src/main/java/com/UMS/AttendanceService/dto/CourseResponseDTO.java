package com.UMS.AttendanceService.dto;

import lombok.Data;

@Data
public class CourseResponseDTO {
    private Long courseId;

    private String courseName;

    private String courseCode;

    private String status;
}
