package com.UMS.ExaminationService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "exams")
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    private Long courseId;

    private Long teacherId;

    private String examType;

    private LocalDate examDate;

    private LocalTime startTime;

    private LocalTime endTime;
    @Column(nullable = false, unique = true)
    private String roomNumber;

    private Integer totalMarks;

    private String status;
}
