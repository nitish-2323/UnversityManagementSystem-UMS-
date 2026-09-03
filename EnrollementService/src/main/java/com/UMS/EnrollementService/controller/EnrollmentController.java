package com.UMS.EnrollementService.controller;

import com.UMS.EnrollementService.dto.EnrollmentRequestDTO;
import com.UMS.EnrollementService.dto.EnrollmentResponseDTO;
import com.UMS.EnrollementService.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> createEnrollment(
            @RequestBody EnrollmentRequestDTO requestDTO) {

        EnrollmentResponseDTO responseDTO = enrollmentService.createEnrollment(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentResponseDTO> getEnrollmentById(
            @PathVariable Long enrollmentId) {

        EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.getEnrollmentById(enrollmentId);

        return new ResponseEntity<>(enrollmentResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments() {

        List<EnrollmentResponseDTO> enrollmentResponseDTO = enrollmentService.getAllEnrollments();

        return new ResponseEntity<>(enrollmentResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentResponseDTO> updateEnrollment(
            @PathVariable Long enrollmentId,
            @RequestBody EnrollmentRequestDTO requestDTO) {

        EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.updateEnrollment(
                        enrollmentId, requestDTO);

        return new ResponseEntity<>(enrollmentResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(
            @PathVariable Long enrollmentId) {

        enrollmentService.deleteEnrollment(enrollmentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
