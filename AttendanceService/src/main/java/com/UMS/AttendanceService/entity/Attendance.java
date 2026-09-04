package com.UMS.AttendanceService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    private Long studentId;

    private Long courseId;

    private LocalDate attendanceDate;

    private String status;

    private String semester;
}
