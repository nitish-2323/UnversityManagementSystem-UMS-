package com.UMS.ExaminationService.controller;

import com.UMS.ExaminationService.dto.ResultRequestDTO;
import com.UMS.ExaminationService.dto.ResultResponseDTO;
import com.UMS.ExaminationService.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    @PostMapping
    public ResponseEntity<ResultResponseDTO> createResult(
            @RequestBody ResultRequestDTO resultRequestDTO) {

        return new ResponseEntity<>(
                resultService.createResult(resultRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{resultId}")
    public ResponseEntity<ResultResponseDTO> getResultById(
            @PathVariable Long resultId) {

        return ResponseEntity.ok(
                resultService.getResultById(resultId)
        );
    }

    @GetMapping
    public ResponseEntity<List<ResultResponseDTO>> getAllResults() {

        return ResponseEntity.ok(
                resultService.getAllResults()
        );
    }

    @PutMapping("/{resultId}")
    public ResponseEntity<ResultResponseDTO> updateResult(
            @PathVariable Long resultId,
            @RequestBody ResultRequestDTO resultRequestDTO) {

        return ResponseEntity.ok(
                resultService.updateResult(resultId, resultRequestDTO)
        );
    }

    @DeleteMapping("/{resultId}")
    public ResponseEntity<String> deleteResult(
            @PathVariable Long resultId) {

        resultService.deleteResult(resultId);

        return ResponseEntity.ok("Result deleted successfully");
    }
}
