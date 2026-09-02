package com.UMS.CourseService.entity;

import com.UMS.CourseService.dto.DepartmentResponseDTO;
import com.UMS.CourseService.dto.TeacherResponseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String courseName;

    private String description;

    @Column(nullable = false)
    private Integer credits;

    private Long departmentId;

    private Long teacherId;

    private String semester;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
