package com.UMS.TimetableService.dto;

import lombok.Data;

@Data
public class CourseResponseDTO {
    private Long courseId;

    private String courseName;

    private String courseCode;

    private String description;

    private Integer credits;

    private String status;
}
