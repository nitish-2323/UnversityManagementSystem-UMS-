package com.UMS.RoleService.Service;

import com.UMS.RoleService.DTO.RoleRequestDTO;
import com.UMS.RoleService.DTO.RoleResponseDTO;
import com.UMS.RoleService.Entity.Role;
import com.UMS.RoleService.Execption.RoleNotFound;
import com.UMS.RoleService.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceIml implements RoleService{
    private final RoleRepository roleRepository;
    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();

        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        role.setStatus(roleRequestDTO.getStatus());
        role.setCreatedAt(LocalDateTime.now());

        Role savedRole = roleRepository.save(role);

        return convertToResponseDTO(savedRole);

    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    @Override
    public RoleResponseDTO getRoleById(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() ->
                        new RoleNotFound("Role not found with ID: " + roleId));

        return convertToResponseDTO(role);
    }

    @Override
    public RoleResponseDTO updateRole(Long roleId, RoleRequestDTO roleRequestDTO) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() ->
                        new RoleNotFound("Role not found with ID: " + roleId));

        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        role.setStatus(roleRequestDTO.getStatus());

        Role updatedRole = roleRepository.save(role);

        return convertToResponseDTO(updatedRole);
    }

    @Override
    public void deleteRole(Long roleId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() ->
                        new RoleNotFound("Role not found with ID: " + roleId));

        roleRepository.delete(role);
    }
    private RoleResponseDTO convertToResponseDTO(Role role) {

        RoleResponseDTO responseDTO = new RoleResponseDTO();

        responseDTO.setRoleId(role.getRoleId());
        responseDTO.setRoleName(role.getRoleName());
        responseDTO.setDescription(role.getDescription());
        responseDTO.setStatus(role.getStatus());
        responseDTO.setCreatedAt(role.getCreatedAt());

        return responseDTO;
    }
}
