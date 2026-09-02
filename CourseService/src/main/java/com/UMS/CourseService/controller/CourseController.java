package com.UMS.CourseService.controller;

import com.UMS.CourseService.dto.CourseRequestDTO;
import com.UMS.CourseService.dto.CourseResponseDTO;
import com.UMS.CourseService.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(
            @RequestBody CourseRequestDTO requestDTO) {

        CourseResponseDTO responseDTO = courseService.createCourse(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponseDTO> getCourseById(
            @PathVariable Long courseId) {

        CourseResponseDTO responseDTO = courseService.getCourseById(courseId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {

        List<CourseResponseDTO> responseDTO = courseService.getAllCourses();
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseResponseDTO> updateCourse(
            @PathVariable Long courseId,
            @RequestBody CourseRequestDTO requestDTO) {

        CourseResponseDTO responseDTO = courseService.updateCourse(courseId, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(
            @PathVariable Long courseId) {

        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
