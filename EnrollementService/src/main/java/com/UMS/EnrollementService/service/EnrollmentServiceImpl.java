package com.UMS.EnrollementService.service;

import com.UMS.EnrollementService.client.CourseClient;
import com.UMS.EnrollementService.client.StudentClient;
import com.UMS.EnrollementService.dto.CourseResponseDTO;
import com.UMS.EnrollementService.dto.EnrollmentRequestDTO;
import com.UMS.EnrollementService.dto.EnrollmentResponseDTO;
import com.UMS.EnrollementService.dto.StudentResponseDTO;
import com.UMS.EnrollementService.entity.Enrollment;
import com.UMS.EnrollementService.execption.EnrollmentNotFoundException;
import com.UMS.EnrollementService.mapper.EnrollmentMapper;
import com.UMS.EnrollementService.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    private final StudentClient studentClient;
    private final CourseClient courseClient;

    @Override
    public EnrollmentResponseDTO createEnrollment(
            EnrollmentRequestDTO requestDTO) {

        Enrollment enrollment = enrollmentMapper.toEntity(requestDTO);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return buildEnrollmentResponse(savedEnrollment);
    }

    @Override
    public EnrollmentResponseDTO getEnrollmentById(Long enrollmentId) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException(
                        "Enrollment not found with id: " + enrollmentId));

        return buildEnrollmentResponse(enrollment);
    }

    @Override
    public List<EnrollmentResponseDTO> getAllEnrollments() {

        List<Enrollment> enrollments = enrollmentRepository.findAll();

        return enrollments.stream()
                .map(this::buildEnrollmentResponse)
                .toList();
    }

    @Override
    public EnrollmentResponseDTO updateEnrollment(
            Long enrollmentId,
            EnrollmentRequestDTO requestDTO) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException(
                        "Enrollment not found with id: " + enrollmentId));

        enrollment.setStudentId(requestDTO.getStudentId());
        enrollment.setCourseId(requestDTO.getCourseId());
        enrollment.setEnrollmentDate(requestDTO.getEnrollmentDate());
        enrollment.setSemester(requestDTO.getSemester());
        enrollment.setStatus(requestDTO.getStatus());

        Enrollment updatedEnrollment =
                enrollmentRepository.save(enrollment);

        return buildEnrollmentResponse(updatedEnrollment);
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException(
                        "Enrollment not found with id: " + enrollmentId));

        enrollmentRepository.delete(enrollment);
    }

    private EnrollmentResponseDTO buildEnrollmentResponse(
            Enrollment enrollment) {

        EnrollmentResponseDTO responseDTO = enrollmentMapper.toResponseDTO(enrollment);

        StudentResponseDTO student = studentClient.getStudentById(enrollment.getStudentId());

        CourseResponseDTO course = courseClient.getCourseById(enrollment.getCourseId());

        responseDTO.setStudentResponseDTO(student);
        responseDTO.setCourseResponseDTO(course);

        return responseDTO;
    }
}