package com.UMS.EnrollementService.service;

import com.UMS.EnrollementService.dto.EnrollmentRequestDTO;
import com.UMS.EnrollementService.dto.EnrollmentResponseDTO;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO requestDTO);

    EnrollmentResponseDTO getEnrollmentById(Long enrollmentId);

    List<EnrollmentResponseDTO> getAllEnrollments();

    EnrollmentResponseDTO updateEnrollment(Long enrollmentId, EnrollmentRequestDTO requestDTO);

    void deleteEnrollment(Long enrollmentId);
}
