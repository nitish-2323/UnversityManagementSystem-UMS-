package com.UMS.AttendanceService.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceRequestDTO {
    private Long studentId;

    private Long courseId;

    private LocalDate attendanceDate;

    private String status;

    private String semester;
}
