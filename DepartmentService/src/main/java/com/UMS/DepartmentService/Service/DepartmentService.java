package com.UMS.DepartmentService.Service;

import com.UMS.DepartmentService.DTO.DepartmentRequestDTO;
import com.UMS.DepartmentService.DTO.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO);

    DepartmentResponseDTO getDepartmentById(Long departmentId);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO requestDTO);

    void deleteDepartment(Long departmentId);
}
