package com.UMS.TeacherService.service;

import com.UMS.TeacherService.client.TeacherClient;
import com.UMS.TeacherService.dto.DepartmentResponseDTO;
import com.UMS.TeacherService.dto.RoleResponseDTO;
import com.UMS.TeacherService.dto.TeacherRequestDTO;
import com.UMS.TeacherService.dto.TeacherResponseDTO;
import com.UMS.TeacherService.entity.Teacher;
import com.UMS.TeacherService.execption.TeacherNotFoundExecption;
import com.UMS.TeacherService.mapper.TeacherMapper;
import com.UMS.TeacherService.repository.TeacherRepository;
import com.UMS.TeacherService.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final TeacherClient teacherClient;
    @Override
    public TeacherResponseDTO createTeacher(TeacherRequestDTO dto) {
        Teacher teacher = teacherMapper.toEntity(dto);
        return teacherMapper.toResponseDTO(teacherRepository.save(teacher));
    }

    @Override
    public TeacherResponseDTO getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundExecption("Teacher not found"));
        TeacherResponseDTO responseDTO =teacherMapper.toResponseDTO(teacher);
        DepartmentResponseDTO departmentDTO = teacherClient.getDepartmentByID(teacher.getDepartmentId());
        RoleResponseDTO responseRoleDTO =teacherClient.getRoleById(teacher.getRoleId());
        responseDTO.setResponseDepartmentDTO(departmentDTO);
        responseDTO.setResponseRoleDTO(responseRoleDTO);
        return responseDTO;
    }

    @Override
    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toResponseDTO)
                .toList();
    }

    @Override
    public TeacherResponseDTO updateTeacher(Long teacherId, TeacherRequestDTO dto) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundExecption("Teacher not found"));

        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setUsername(dto.getUsername());
        teacher.setEmail(dto.getEmail());
        teacher.setMobile(dto.getMobile());
        teacher.setDepartmentId(dto.getDepartmentId());
        teacher.setRoleId(dto.getRoleId());

        return teacherMapper.toResponseDTO(teacherRepository.save(teacher));
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundExecption("Teacher not found"));

        teacherRepository.delete(teacher);
    }
}