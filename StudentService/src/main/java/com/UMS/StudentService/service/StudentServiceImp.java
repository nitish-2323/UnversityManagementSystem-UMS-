package com.UMS.StudentService.service;

import com.UMS.StudentService.Client.StudentClient;
import com.UMS.StudentService.dto.*;
import com.UMS.StudentService.entity.Student;
import com.UMS.StudentService.execption.StudentNotFound;
import com.UMS.StudentService.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository repository;
    private final RestTemplate restTemplate;
    private final StudentClient studentClient;

    @Override
    public StudentResponseDTO getStudentById(Long studentId) {

        Student student = repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student not found"));
        StudentResponseDTO responseDTO = mapToResponse(student);
        DepartmentResponseDTO departmentDTO =studentClient.getDepartmentByID(student.getDepartmentId());
        RoleResponseDTO responseRoleDTO =studentClient.getRoleById(student.getRoleId());
        responseDTO.setResponseDepartmentDTO(departmentDTO);
        responseDTO.setResponseRoleDTO(responseRoleDTO);
        return responseDTO;
    }


    @Override
    public StudentResponseDTO updateStudent(
            Long studentId,
            StudentRequestDTO request) {

        Student student = repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student not found"));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setMobile(request.getMobile());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGender(request.getGender());
        student.setAddress(request.getAddress());

        return mapToResponse(repository.save(student));
    }

    @Override
    public String getStudentStatus(Long studentId) {

        Student student = repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student not found"));

        return student.getStatus();
    }

    @Override
    public StudentResponseDTO createStudent(AdminStudentRequestDTO requestDTO) {
        Student student = new Student();

        student.setFirstName(requestDTO.getFirstName());
        student.setLastName(requestDTO.getLastName());
        student.setUsername(requestDTO.getUsername());
        student.setEmail(requestDTO.getEmail());
        student.setPassword(requestDTO.getPassword());
        student.setMobile(requestDTO.getMobile());
        student.setDateOfBirth(requestDTO.getDateOfBirth());
        student.setGender(requestDTO.getGender());
        student.setAddress(requestDTO.getAddress());
        student.setDepartmentId(requestDTO.getDepartmentId());
        student.setRoleId(requestDTO.getRoleId());
        student.setStatus(requestDTO.getStatus());

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = repository.save(student);

        return mapToResponse(savedStudent);
    }

    private StudentResponseDTO mapToResponse(Student student) {

        StudentResponseDTO response = new StudentResponseDTO();

        response.setStudentId(student.getStudentId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setUsername(student.getUsername());
        response.setEmail(student.getEmail());
        response.setMobile(student.getMobile());
        response.setDateOfBirth(student.getDateOfBirth());
        response.setGender(student.getGender());
        response.setAddress(student.getAddress());
        response.setDepartmentId(student.getDepartmentId());
        response.setStatus(student.getStatus());
        response.setCreatedAt(student.getCreatedAt());
        response.setUpdatedAt(student.getUpdatedAt());

        return response;
    }
}
