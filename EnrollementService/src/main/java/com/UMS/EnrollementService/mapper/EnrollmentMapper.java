package com.UMS.EnrollementService.mapper;

import com.UMS.EnrollementService.dto.EnrollmentRequestDTO;
import com.UMS.EnrollementService.dto.EnrollmentResponseDTO;
import com.UMS.EnrollementService.entity.Enrollment;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EnrollmentMapper {
    public EnrollmentResponseDTO toResponseDTO(Enrollment enrollment) {

        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();

        dto.setEnrollmentId(enrollment.getEnrollmentId());
        dto.setStudentId(enrollment.getStudentId());
        dto.setCourseId(enrollment.getCourseId());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());
        dto.setSemester(enrollment.getSemester());
        dto.setStatus(enrollment.getStatus());

        return dto;
    }

    public Enrollment toEntity(EnrollmentRequestDTO dto) {

        Enrollment enrollment = new Enrollment();

        enrollment.setStudentId(dto.getStudentId());
        enrollment.setCourseId(dto.getCourseId());
        enrollment.setEnrollmentDate(dto.getEnrollmentDate());
        enrollment.setSemester(dto.getSemester());
        enrollment.setStatus(dto.getStatus());

        return enrollment;
    }
}
