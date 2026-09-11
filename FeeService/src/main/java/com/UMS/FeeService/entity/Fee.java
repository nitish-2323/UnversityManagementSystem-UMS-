package com.UMS.FeeService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fees")
@Data
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeId;

    private Long studentId;

    private Double amount;

    private Double paidAmount;

    private Double remainingAmount;

    private String feeType;

    private String paymentStatus;

    private LocalDateTime dueDate;

    private LocalDateTime paidAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
