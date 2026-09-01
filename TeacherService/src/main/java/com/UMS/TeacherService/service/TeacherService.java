package com.UMS.TeacherService.service;

import com.UMS.TeacherService.dto.TeacherRequestDTO;
import com.UMS.TeacherService.dto.TeacherResponseDTO;

import java.util.List;

public interface TeacherService {
    TeacherResponseDTO createTeacher(TeacherRequestDTO requestDTO);

    TeacherResponseDTO getTeacherById(Long teacherId);

    List<TeacherResponseDTO> getAllTeachers();

    TeacherResponseDTO updateTeacher(Long teacherId, TeacherRequestDTO requestDTO);

    void deleteTeacher(Long teacherId);
}
