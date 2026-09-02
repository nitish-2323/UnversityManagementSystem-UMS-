package com.UMS.CourseService.dto;

import lombok.Data;

@Data
public class CourseRequestDTO {

    private String courseCode;

    private String courseName;

    private String description;

    private Integer credits;

    private Long departmentId;

    private Long teacherId;

    private String semester;

    private String status;
}
