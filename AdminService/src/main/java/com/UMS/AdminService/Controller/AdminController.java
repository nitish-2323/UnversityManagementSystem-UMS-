package com.UMS.AdminService.Controller;

import com.UMS.AdminService.DTO.AdminRequestDTO;
import com.UMS.AdminService.DTO.AdminResponseDTO;
import com.UMS.AdminService.DTO.StudentRequestDTO;
import com.UMS.AdminService.DTO.StudentResponseDTO;
import com.UMS.AdminService.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<AdminResponseDTO> createAdmin(
            @RequestBody AdminRequestDTO requestDTO) {

        AdminResponseDTO responseDTO =
                adminService.createAdmin(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminResponseDTO> getAdmin(
            @PathVariable Long adminId) {

        AdminResponseDTO responseDTO =
                adminService.getAdminById(adminId);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdminResponseDTO>> getAllAdmins() {

        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<AdminResponseDTO> updateAdmin(
            @PathVariable Long adminId,
            @RequestBody AdminRequestDTO requestDTO) {

        AdminResponseDTO responseDTO =
                adminService.updateAdmin(adminId, requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/{adminId}")
    public ResponseEntity<AdminResponseDTO> patchAdmin(
            @PathVariable Long adminId,
            @RequestBody AdminRequestDTO requestDTO) {

        AdminResponseDTO responseDTO =
                adminService.patchAdmin(adminId, requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(
            @PathVariable Long adminId) {

        adminService.deleteAdmin(adminId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{adminId}/students")
    public ResponseEntity<StudentResponseDTO> createStudent(
            @PathVariable Long adminId, @RequestBody StudentRequestDTO studentRequestDTO) {

        StudentResponseDTO responseDTO = adminService.createStudent(adminId,studentRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}