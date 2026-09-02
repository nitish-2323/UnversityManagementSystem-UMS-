package com.UMS.CourseService.service;

import com.UMS.CourseService.dto.CourseRequestDTO;
import com.UMS.CourseService.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {
    CourseResponseDTO createCourse(CourseRequestDTO requestDTO);

    CourseResponseDTO getCourseById(Long courseId);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO requestDTO);

    void deleteCourse(Long courseId);
}
