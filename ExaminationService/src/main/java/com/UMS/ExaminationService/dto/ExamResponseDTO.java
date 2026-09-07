package com.UMS.ExaminationService.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ExamResponseDTO {
    private Long examId;
    private Long courseId;
    private Long teacherId;
    private String examType;
    private LocalDate examDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String roomNumber;
    private Integer totalMarks;
    private String status;
    private CourseResponseDTO course;
    private TeacherResponseDTO teacher;
}
