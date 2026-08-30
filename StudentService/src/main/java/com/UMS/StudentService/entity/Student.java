package com.UMS.StudentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String mobile;

    private LocalDate dateOfBirth;

    private String gender;

    private String address;

    private Long departmentId;

    private Long roleId;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}