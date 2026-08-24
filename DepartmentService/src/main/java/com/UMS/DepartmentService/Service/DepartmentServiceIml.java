package com.UMS.DepartmentService.Service;

import com.UMS.DepartmentService.DTO.DepartmentRequestDTO;
import com.UMS.DepartmentService.DTO.DepartmentResponseDTO;
import com.UMS.DepartmentService.Entity.Department;
import com.UMS.DepartmentService.Execption.DepartmentIdNotFound;
import com.UMS.DepartmentService.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceIml implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO) {
        Department department = new Department();
        department.setDepartmentCode(requestDTO.getDepartmentCode());
        department.setDepartmentName(requestDTO.getDepartmentName());
        department.setDescription(requestDTO.getDescription());
        department.setHodName(requestDTO.getHodName());
        department.setEmail(requestDTO.getEmail());
        department.setPhone(requestDTO.getPhone());
        department.setStatus("ACTIVE");
        Department department1   = departmentRepository.save(department);
        return convertToDepartmentResponseDTO(department1);
    }


    @Override
    public DepartmentResponseDTO getDepartmentById(Long departmentId) {
        Department responseDTO =departmentRepository.findById(departmentId)
                .orElseThrow(()-> new DepartmentIdNotFound("Department not found"));

        return convertToDepartmentResponseDTO(responseDTO);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return  departmentRepository.findAll()
                .stream()
                .map(this::convertToDepartmentResponseDTO)
                .toList();

    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO requestDTO) {
        Department department =departmentRepository.findById(departmentId)
                .orElseThrow(()-> new DepartmentIdNotFound("Department Not Found"));

        department.setDepartmentCode(requestDTO.getDepartmentCode());
        department.setDepartmentName(requestDTO.getDepartmentName());
        department.setDescription(requestDTO.getDescription());
        department.setHodName(requestDTO.getHodName());
        department.setEmail(requestDTO.getEmail());
        department.setPhone(requestDTO.getPhone());

        Department department1 =departmentRepository.save(department);

        return convertToDepartmentResponseDTO(department1);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new DepartmentIdNotFound("Department not found"));
        departmentRepository.delete(department);

    }
    private DepartmentResponseDTO convertToDepartmentResponseDTO(Department department1) {
        DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();

        responseDTO.setDepartmentId(department1.getDepartmentId());
        responseDTO.setDepartmentCode(department1.getDepartmentCode());
        responseDTO.setDepartmentName(department1.getDepartmentName());
        responseDTO.setDescription(department1.getDescription());
        responseDTO.setHodName(department1.getHodName());
        responseDTO.setEmail(department1.getEmail());
        responseDTO.setPhone(department1.getPhone());
        responseDTO.setStatus(department1.getStatus());
        responseDTO.setCreatedAt(department1.getCreatedAt());
        responseDTO.setUpdatedAt(department1.getUpdatedAt());

        return responseDTO;
    }
}
