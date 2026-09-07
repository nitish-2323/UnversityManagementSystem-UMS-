package com.UMS.ExaminationService.service;

import com.UMS.ExaminationService.dto.ExamRequestDTO;
import com.UMS.ExaminationService.dto.ExamResponseDTO;

import java.util.List;

public interface ExamService {
    ExamResponseDTO createExam(ExamRequestDTO examRequestDTO);

    ExamResponseDTO getExamById(Long examId);

    List<ExamResponseDTO> getAllExams();

    ExamResponseDTO updateExam(Long examId, ExamRequestDTO examRequestDTO);

    void deleteExam(Long examId);
}
