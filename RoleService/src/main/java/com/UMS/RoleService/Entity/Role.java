package com.UMS.RoleService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(unique = true, nullable = false)
    private String roleName;

    private String description;

    private String status;

    private LocalDateTime createdAt;
}
