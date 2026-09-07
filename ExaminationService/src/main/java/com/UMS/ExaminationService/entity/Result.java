package com.UMS.ExaminationService.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "results")
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    private Long examId;

    private Long studentId;

    private Double marksObtained;

    private String grade;

    private String status;
}
