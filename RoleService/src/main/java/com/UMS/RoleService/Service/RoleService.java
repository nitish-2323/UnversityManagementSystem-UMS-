package com.UMS.RoleService.Service;

import com.UMS.RoleService.DTO.RoleRequestDTO;
import com.UMS.RoleService.DTO.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);

    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO getRoleById(Long roleId);

    RoleResponseDTO updateRole(Long roleId, RoleRequestDTO roleRequestDTO);

    void deleteRole(Long roleId);
}
