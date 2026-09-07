package com.UMS.ExaminationService.mapper;

import com.UMS.ExaminationService.dto.ExamRequestDTO;
import com.UMS.ExaminationService.dto.ExamResponseDTO;
import com.UMS.ExaminationService.entity.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {
    public Exam toEntity(ExamRequestDTO dto) {

        Exam exam = new Exam();

        exam.setCourseId(dto.getCourseId());
        exam.setTeacherId(dto.getTeacherId());
        exam.setExamType(dto.getExamType());
        exam.setExamDate(dto.getExamDate());
        exam.setStartTime(dto.getStartTime());
        exam.setEndTime(dto.getEndTime());
        exam.setRoomNumber(dto.getRoomNumber());
        exam.setTotalMarks(dto.getTotalMarks());
        exam.setStatus(dto.getStatus());

        return exam;
    }

    public ExamResponseDTO toResponseDTO(Exam exam) {

        ExamResponseDTO dto = new ExamResponseDTO();

        dto.setExamId(exam.getExamId());
        dto.setCourseId(exam.getCourseId());
        dto.setTeacherId(exam.getTeacherId());
        dto.setExamType(exam.getExamType());
        dto.setExamDate(exam.getExamDate());
        dto.setStartTime(exam.getStartTime());
        dto.setEndTime(exam.getEndTime());
        dto.setRoomNumber(exam.getRoomNumber());
        dto.setTotalMarks(exam.getTotalMarks());
        dto.setStatus(exam.getStatus());

        return dto;
    }
}
