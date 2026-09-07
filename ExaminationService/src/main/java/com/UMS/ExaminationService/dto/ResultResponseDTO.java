package com.UMS.ExaminationService.dto;

import lombok.Data;

@Data
public class ResultResponseDTO {
    private Long resultId;
    private Long examId;
    private Long studentId;
    private Double marksObtained;
    private String grade;
    private String status;
    private StudentResponseDTO student;

}
