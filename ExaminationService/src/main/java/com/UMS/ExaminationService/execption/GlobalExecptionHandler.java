package com.UMS.ExaminationService.execption;


import com.UMS.ExaminationService.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExecptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> execptionDepartmentIdNotFound(Exception e, WebRequest webRequest){
        ExceptionDTO obj = new ExceptionDTO();
        obj.setStatus(HttpStatus.NOT_FOUND.value());
        obj.setMsg(e.getMessage());
        obj.setPath(webRequest.getDescription(false));
        obj.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }
}
