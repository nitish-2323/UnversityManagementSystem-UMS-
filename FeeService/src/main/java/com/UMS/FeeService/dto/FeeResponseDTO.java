package com.UMS.FeeService.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FeeResponseDTO {
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

    private  StudentResponseDTO studentResponseDTO;
}
