package com.UMS.DepartmentService.Controller;

import com.UMS.DepartmentService.DTO.DepartmentRequestDTO;
import com.UMS.DepartmentService.DTO.DepartmentResponseDTO;
import com.UMS.DepartmentService.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
        @PostMapping("/create")
    public ResponseEntity<DepartmentResponseDTO> createDepartment(
            @RequestBody DepartmentRequestDTO requestDTO){
            DepartmentResponseDTO responseDTO =departmentService.createDepartment(requestDTO);
         return  new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
        }
        @GetMapping("/{departmentId}")
        public ResponseEntity<DepartmentResponseDTO> getDepartment(@PathVariable Long departmentId){
            DepartmentResponseDTO responseDTO =departmentService.getDepartmentById(departmentId);
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
        @GetMapping
        public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
                 return ResponseEntity.ok( departmentService.getAllDepartments());
        }
        @PutMapping("/{departmentId}")
        public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable Long departmentId
                ,@RequestBody DepartmentRequestDTO requestDTO){
            DepartmentResponseDTO responseDTO =departmentService.updateDepartment(departmentId,requestDTO);
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
        @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId){
            departmentService.deleteDepartment(departmentId);
            return ResponseEntity.noContent().build();
        }

}
