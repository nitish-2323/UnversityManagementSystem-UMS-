package com.UMS.EnrollementService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    private Long studentId;

    private Long courseId;

    private LocalDate enrollmentDate;

    private String semester;

    private String status;
}
