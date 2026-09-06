package com.UMS.AdminService.Mapper;

import com.UMS.AdminService.DTO.AdminRequestDTO;
import com.UMS.AdminService.DTO.AdminResponseDTO;
import com.UMS.AdminService.Entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public Admin toEntity(AdminRequestDTO requestDTO) {

        Admin admin = new Admin();

        admin.setFirstName(requestDTO.getFirstName());
        admin.setLastName(requestDTO.getLastName());
        admin.setUsername(requestDTO.getUsername());
        admin.setEmail(requestDTO.getEmail());
        admin.setPassword(requestDTO.getPassword());
        admin.setMobile(requestDTO.getMobile());
        admin.setDepartmentId(requestDTO.getDepartmentId());
        admin.setRoleId(requestDTO.getRoleId());
        admin.setStatus(requestDTO.getStatus());

        return admin;
    }

    public AdminResponseDTO toResponseDTO(Admin admin) {

        AdminResponseDTO responseDTO = new AdminResponseDTO();

        responseDTO.setId(admin.getId());
        responseDTO.setFirstName(admin.getFirstName());
        responseDTO.setLastName(admin.getLastName());
        responseDTO.setUsername(admin.getUsername());
        responseDTO.setEmail(admin.getEmail());
        responseDTO.setMobile(admin.getMobile());
        responseDTO.setDepartmentId(admin.getDepartmentId());
        responseDTO.setRoleId(admin.getRoleId());
        responseDTO.setStatus(admin.getStatus());
        responseDTO.setCreatedAt(admin.getCreatedAt());
        responseDTO.setUpdatedAt(admin.getUpdatedAt());

        return responseDTO;
    }
}
