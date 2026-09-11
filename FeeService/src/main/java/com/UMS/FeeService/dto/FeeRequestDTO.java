package com.UMS.FeeService.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FeeRequestDTO {
    private Long studentId;

    private Double amount;

    private Double paidAmount;

    private String feeType;

    private String paymentStatus;

    private LocalDateTime dueDate;
}
