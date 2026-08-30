package com.UMS.StudentService.service;

import com.UMS.StudentService.dto.AdminStudentRequestDTO;
import com.UMS.StudentService.dto.StudentRequestDTO;
import com.UMS.StudentService.dto.StudentResponseDTO;
import com.UMS.StudentService.entity.Student;

public interface StudentService {
    StudentResponseDTO getStudentById(Long studentId);

    StudentResponseDTO updateStudent(Long studentId, StudentRequestDTO request);

    String getStudentStatus(Long studentId);


    StudentResponseDTO createStudent(AdminStudentRequestDTO requestDTO);
}