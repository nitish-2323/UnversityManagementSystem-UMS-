package com.UMS.ExaminationService.controller;

import com.UMS.ExaminationService.dto.ExamRequestDTO;
import com.UMS.ExaminationService.dto.ExamResponseDTO;
import com.UMS.ExaminationService.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    @PostMapping
    public ResponseEntity<ExamResponseDTO> createExam(
            @RequestBody ExamRequestDTO examRequestDTO) {

        return new ResponseEntity<>(examService.createExam(examRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<ExamResponseDTO> getExamById(
            @PathVariable Long examId) {

        return ResponseEntity.ok(examService.getExamById(examId));
    }

    @GetMapping
    public ResponseEntity<List<ExamResponseDTO>> getAllExams() {

        return ResponseEntity.ok(examService.getAllExams());
    }

    @PutMapping("/{examId}")
    public ResponseEntity<ExamResponseDTO> updateExam(
            @PathVariable Long examId,
            @RequestBody ExamRequestDTO examRequestDTO) {

        return ResponseEntity.ok(
                examService.updateExam(examId, examRequestDTO)
        );
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(
            @PathVariable Long examId) {

        examService.deleteExam(examId);

        return ResponseEntity.ok("Exam deleted successfully");
    }
}
