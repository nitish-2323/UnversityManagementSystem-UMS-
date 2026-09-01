package com.UMS.TeacherService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String mobile;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private String qualification;

    private String specialization;

    private LocalDate joiningDate;

    private Long departmentId;

    private Long roleId;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}