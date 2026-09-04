package com.UMS.AttendanceService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceResponseDTO {
    private Long attendanceId;

    private Long studentId;

    private Long courseId;

    private LocalDate attendanceDate;

    private String status;

    private String semester;

    private StudentResponseDTO student;

    private CourseResponseDTO course;
}
