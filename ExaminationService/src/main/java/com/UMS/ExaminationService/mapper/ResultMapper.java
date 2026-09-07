package com.UMS.ExaminationService.mapper;

import com.UMS.ExaminationService.dto.ResultRequestDTO;
import com.UMS.ExaminationService.dto.ResultResponseDTO;
import com.UMS.ExaminationService.entity.Result;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {
    public Result toEntity(ResultRequestDTO dto) {

        Result result = new Result();

        result.setExamId(dto.getExamId());
        result.setStudentId(dto.getStudentId());
        result.setMarksObtained(dto.getMarksObtained());
        result.setGrade(dto.getGrade());
        result.setStatus(dto.getStatus());

        return result;
    }

    public ResultResponseDTO toResponseDTO(Result result) {

        ResultResponseDTO dto = new ResultResponseDTO();

        dto.setResultId(result.getResultId());
        dto.setExamId(result.getExamId());
        dto.setStudentId(result.getStudentId());
        dto.setMarksObtained(result.getMarksObtained());
        dto.setGrade(result.getGrade());
        dto.setStatus(result.getStatus());

        return dto;
    }
}
