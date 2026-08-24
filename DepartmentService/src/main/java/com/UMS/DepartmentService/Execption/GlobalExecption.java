package com.UMS.DepartmentService.Execption;

import com.UMS.DepartmentService.DTO.ExecptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExecption {
    @ExceptionHandler(DepartmentIdNotFound.class)
    public ResponseEntity<ExecptionDTO> execptionDepartmentIdNotFound(Exception e, WebRequest webRequest){
        ExecptionDTO obj = new ExecptionDTO();
        obj.setStatus(HttpStatus.NOT_FOUND.value());
        obj.setMsg(e.getMessage());
        obj.setPath(webRequest.getDescription(false));
        obj.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }
}
