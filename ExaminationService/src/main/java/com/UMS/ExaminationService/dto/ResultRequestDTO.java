package com.UMS.ExaminationService.dto;

import lombok.Data;

@Data
public class ResultRequestDTO {
    private Long examId;
    private Long studentId;
    private Double marksObtained;
    private String grade;
    private String status;
}
