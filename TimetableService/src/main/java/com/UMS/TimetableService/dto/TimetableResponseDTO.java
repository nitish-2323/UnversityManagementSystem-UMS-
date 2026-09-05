package com.UMS.TimetableService.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class TimetableResponseDTO {
    private Long timetableId;

    private Long courseId;

    private Long teacherId;

    private Long departmentId;

    private String semester;

    private String roomNumber;

    private String dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private CourseResponseDTO courseResponseDTO;

    private DepartmentResponseDTO departmentResponseDTO;

    private TeacherResponseDTO teacherResponseDTO;

}
