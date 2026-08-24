package com.UMS.DepartmentService.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "departments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "departmentCode")
        }
)
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(nullable = false, unique = true)
    private String departmentCode;

    @Column(nullable = false)
    private String departmentName;

    private String description;

    private String hodName;

    private String email;

    private String phone;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
