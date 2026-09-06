package com.UMS.AdminService.Service;

import com.UMS.AdminService.DTO.AdminRequestDTO;
import com.UMS.AdminService.DTO.AdminResponseDTO;
import com.UMS.AdminService.DTO.StudentRequestDTO;
import com.UMS.AdminService.DTO.StudentResponseDTO;

import java.util.List;

public interface AdminService {
    AdminResponseDTO createAdmin(AdminRequestDTO requestDTO);

    AdminResponseDTO getAdminById(Long id);

    List<AdminResponseDTO> getAllAdmins();

    AdminResponseDTO updateAdmin(Long id, AdminRequestDTO requestDTO);

    AdminResponseDTO patchAdmin(Long id, AdminRequestDTO requestDTO);

    void deleteAdmin(Long id);


    StudentResponseDTO createStudent(Long adminId, StudentRequestDTO studentRequestDTO);
}
