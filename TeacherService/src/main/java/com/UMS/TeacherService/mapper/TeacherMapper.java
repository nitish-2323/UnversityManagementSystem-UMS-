package com.UMS.TeacherService.mapper;

import com.UMS.TeacherService.dto.TeacherRequestDTO;
import com.UMS.TeacherService.dto.TeacherResponseDTO;
import com.UMS.TeacherService.entity.Teacher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequestDTO dto) {

        Teacher teacher = new Teacher();

        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setUsername(dto.getUsername());
        teacher.setEmail(dto.getEmail());
        teacher.setMobile(dto.getMobile());
        teacher.setDateOfBirth(dto.getDateOfBirth());
        teacher.setGender(dto.getGender());
        teacher.setAddress(dto.getAddress());
        teacher.setQualification(dto.getQualification());
        teacher.setSpecialization(dto.getSpecialization());
        teacher.setJoiningDate(dto.getJoiningDate());
        teacher.setDepartmentId(dto.getDepartmentId());
        teacher.setRoleId(dto.getRoleId());
        teacher.setStatus("ACTIVE");
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setUpdatedAt(LocalDateTime.now());
        return teacher;
    }

    public TeacherResponseDTO toResponseDTO(Teacher teacher) {

        TeacherResponseDTO dto = new TeacherResponseDTO();

        dto.setTeacherId(teacher.getTeacherId());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setUsername(teacher.getUsername());
        dto.setEmail(teacher.getEmail());
        dto.setMobile(teacher.getMobile());
        dto.setDateOfBirth(teacher.getDateOfBirth());
        dto.setGender(teacher.getGender());
        dto.setAddress(teacher.getAddress());
        dto.setQualification(teacher.getQualification());
        dto.setSpecialization(teacher.getSpecialization());
        dto.setJoiningDate(teacher.getJoiningDate());
        dto.setDepartmentId(teacher.getDepartmentId());
        dto.setRoleId(teacher.getRoleId());
        dto.setStatus(teacher.getStatus());
        dto.setCreatedAt(teacher.getCreatedAt());
        dto.setUpdatedAt(teacher.getUpdatedAt());

        return dto;
    }
}