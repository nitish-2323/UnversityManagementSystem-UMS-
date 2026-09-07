package com.UMS.ExaminationService.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ExceptionDTO {
    private int status;
    private String msg;
    private LocalDateTime dateTime;
    private String path;
}
