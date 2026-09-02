package com.UMS.CourseService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseResponseDTO {
    private Long courseId;

    private String courseCode;

    private String courseName;

    private String description;

    private Integer credits;

    private Long departmentId;

    private Long teacherId;

    private String semester;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private DepartmentResponseDTO departmentResponseDTO;

    private TeacherResponseDTO teacherResponseDTO;


}
