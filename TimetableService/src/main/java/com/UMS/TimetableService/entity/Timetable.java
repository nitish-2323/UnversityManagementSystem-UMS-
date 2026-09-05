package com.UMS.TimetableService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Data
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
