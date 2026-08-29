package com.UMS.RoleService.Controller;

import com.UMS.RoleService.DTO.RoleRequestDTO;
import com.UMS.RoleService.DTO.RoleResponseDTO;
import com.UMS.RoleService.Service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(
            @RequestBody RoleRequestDTO roleRequestDTO) {

        RoleResponseDTO roleResponseDTO =
                roleService.createRole(roleRequestDTO);

        return new ResponseEntity<>(roleResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {

        List<RoleResponseDTO> roleResponseDTO =
                roleService.getAllRoles();

        return new ResponseEntity<>(roleResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleResponseDTO> getRoleById(
            @PathVariable Long roleId) {

        RoleResponseDTO roleResponseDTO =
                roleService.getRoleById(roleId);

        return new ResponseEntity<>(roleResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<RoleResponseDTO> updateRole(
            @PathVariable Long roleId,
            @RequestBody RoleRequestDTO roleRequestDTO) {

        RoleResponseDTO roleResponseDTO =
                roleService.updateRole(roleId, roleRequestDTO);

        return new ResponseEntity<>(roleResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(
            @PathVariable Long roleId) {

        roleService.deleteRole(roleId);

        return ResponseEntity.noContent().build();

    }
}
