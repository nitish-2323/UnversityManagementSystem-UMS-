package com.UMS.AdminService.Service;

import com.UMS.AdminService.Client.AdminClient;
import com.UMS.AdminService.DTO.*;
import com.UMS.AdminService.Entity.Admin;
import com.UMS.AdminService.Execption.AdminIdNotFound;
import com.UMS.AdminService.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceIml implements AdminService {

    private final AdminRepository adminRepository;
    private  final AdminClient adminClient;
    private  final RestTemplate restTemplate;


    @Override
    public AdminResponseDTO createAdmin(AdminRequestDTO requestDTO) {
        Admin admin = new Admin();


        admin.setFirstName(requestDTO.getFirstName());
        admin.setLastName(requestDTO.getLastName());
        admin.setUsername(requestDTO.getUsername());
        admin.setEmail(requestDTO.getEmail());
        admin.setPassword(requestDTO.getPassword());
        admin.setMobile(requestDTO.getMobile());
        admin.setDepartmentId(requestDTO.getDepartmentId());
        admin.setRoleId(requestDTO.getRoleId());
        admin.setStatus("ACTIVE");
        admin.setCreatedAt(LocalDateTime.now());
        admin.setUpdatedAt(LocalDateTime.now());

        Admin admin1 = adminRepository.save(admin);

        return convertToAdminResponseDTO(admin1);
    }

    @Override
    public AdminResponseDTO getAdminById(Long adminId) {

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() ->
                        new AdminIdNotFound("Admin not found"));
        AdminResponseDTO responseDTO =
                convertToAdminResponseDTO(admin);
        RoleResponseDTO roleResponseDTO = adminClient.getRoleById(admin.getRoleId());
        DepartmentResponseDTO departmentResponseDTO = adminClient.getDepartmentById(admin.getDepartmentId());
        responseDTO.setRoleResponseDTO(roleResponseDTO);
        responseDTO.setDepartmentResponseDTO(departmentResponseDTO);
        return responseDTO;
    }

    @Override
    public List<AdminResponseDTO> getAllAdmins() {

        return adminRepository.findAll()
                .stream()
                .map(this::convertToAdminResponseDTO)
                .toList();
    }

    @Override
    public AdminResponseDTO updateAdmin(
            Long adminId,
            AdminRequestDTO requestDTO) {

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() ->
                        new AdminIdNotFound("Admin not found"));

        admin.setFirstName(requestDTO.getFirstName());
        admin.setLastName(requestDTO.getLastName());
        admin.setUsername(requestDTO.getUsername());
        admin.setEmail(requestDTO.getEmail());
        admin.setPassword(requestDTO.getPassword());
        admin.setMobile(requestDTO.getMobile());
        admin.setDepartmentId(requestDTO.getDepartmentId());
        admin.setRoleId(requestDTO.getRoleId());

        admin.setUpdatedAt(LocalDateTime.now());

        Admin admin1 = adminRepository.save(admin);

        return convertToAdminResponseDTO(admin1);
    }

    @Override
    public AdminResponseDTO patchAdmin(
            Long adminId,
            AdminRequestDTO requestDTO) {

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() ->
                        new AdminIdNotFound("Admin not found"));

        if (requestDTO.getFirstName() != null) {
            admin.setFirstName(requestDTO.getFirstName());
        }

        if (requestDTO.getLastName() != null) {
            admin.setLastName(requestDTO.getLastName());
        }

        if (requestDTO.getUsername() != null) {
            admin.setUsername(requestDTO.getUsername());
        }

        if (requestDTO.getEmail() != null) {
            admin.setEmail(requestDTO.getEmail());
        }

        if (requestDTO.getPassword() != null) {
            admin.setPassword(requestDTO.getPassword());
        }

        if (requestDTO.getMobile() != null) {
            admin.setMobile(requestDTO.getMobile());
        }

        if (requestDTO.getDepartmentId() != null) {
            admin.setDepartmentId(requestDTO.getDepartmentId());
        }

        if (requestDTO.getRoleId() != null) {
            admin.setRoleId(requestDTO.getRoleId());
        }

        if (requestDTO.getStatus() != null) {
            admin.setStatus(requestDTO.getStatus());
        }

        admin.setUpdatedAt(LocalDateTime.now());

        Admin admin1 = adminRepository.save(admin);

        return convertToAdminResponseDTO(admin1);
    }

    @Override
    public void deleteAdmin(Long adminId) {

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() ->
                        new AdminIdNotFound("Admin not found"));

        adminRepository.delete(admin);
    }

    @Override
    public StudentResponseDTO createStudent(Long adminId, StudentRequestDTO studentRequestDTO) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() ->
                        new AdminIdNotFound("Admin not found with id: " + adminId));

        StudentResponseDTO responseDTO =
                restTemplate.postForObject(
                        "http://StudentService/students", studentRequestDTO, StudentResponseDTO.class);

        return responseDTO;
    }


    private AdminResponseDTO convertToAdminResponseDTO(Admin admin1) {

        AdminResponseDTO responseDTO = new AdminResponseDTO();

        responseDTO.setId(admin1.getId());
        responseDTO.setFirstName(admin1.getFirstName());
        responseDTO.setLastName(admin1.getLastName());
        responseDTO.setUsername(admin1.getUsername());
        responseDTO.setEmail(admin1.getEmail());
        responseDTO.setMobile(admin1.getMobile());
        responseDTO.setDepartmentId(admin1.getDepartmentId());
        responseDTO.setRoleId(admin1.getRoleId());
        responseDTO.setStatus(admin1.getStatus());
        responseDTO.setCreatedAt(admin1.getCreatedAt());
        responseDTO.setUpdatedAt(admin1.getUpdatedAt());
        return responseDTO;
    }
}