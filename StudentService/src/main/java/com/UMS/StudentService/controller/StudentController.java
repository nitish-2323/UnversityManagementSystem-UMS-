package com.UMS.StudentService.controller;

import com.UMS.StudentService.dto.AdminStudentRequestDTO;
import com.UMS.StudentService.dto.StudentRequestDTO;
import com.UMS.StudentService.dto.StudentResponseDTO;
import com.UMS.StudentService.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
   private  final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(
            @RequestBody AdminStudentRequestDTO requestDTO) {

        StudentResponseDTO responseDTO =
                studentService.createStudent(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDTO> getStudentById(
            @PathVariable Long studentId) {

        StudentResponseDTO studentResponseDTO =
                studentService.getStudentById(studentId);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long studentId,
            @RequestBody StudentRequestDTO studentRequestDTO) {

        StudentResponseDTO studentResponseDTO =
                studentService.updateStudent(studentId, studentRequestDTO);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{studentId}/status")
    public ResponseEntity<String> getStudentStatus(
            @PathVariable Long studentId) {

        String status = studentService.getStudentStatus(studentId);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
