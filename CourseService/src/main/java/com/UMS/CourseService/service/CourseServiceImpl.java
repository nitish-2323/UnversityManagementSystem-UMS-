package com.UMS.CourseService.service;

import com.UMS.CourseService.client.DepartmentClient;
import com.UMS.CourseService.client.TeacherClient;
import com.UMS.CourseService.dto.CourseRequestDTO;
import com.UMS.CourseService.dto.CourseResponseDTO;
import com.UMS.CourseService.dto.DepartmentResponseDTO;
import com.UMS.CourseService.dto.TeacherResponseDTO;
import com.UMS.CourseService.entity.Course;
import com.UMS.CourseService.execption.CourseNotFoundException;
import com.UMS.CourseService.mapper.CourseMapper;
import com.UMS.CourseService.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final DepartmentClient departmentClient;
    private final TeacherClient teacherClient;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {

        Course course = courseMapper.toEntity(requestDTO);

        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toResponseDTO(savedCourse);
    }

    @Override
    public CourseResponseDTO getCourseById(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course not found with id: " + courseId)
                );
        return buildCourseResponse(course);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {

        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(courseMapper::toResponseDTO)
                .toList();
    }

    @Override
    public CourseResponseDTO updateCourse(
            Long courseId,
            CourseRequestDTO requestDTO) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(
                                "Course not found with id: " + courseId)
                );

        courseMapper.updateEntity(course, requestDTO);

        course.setUpdatedAt(LocalDateTime.now());

        Course updatedCourse = courseRepository.save(course);

        return courseMapper.toResponseDTO(updatedCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(
                                "Course not found with id: " + courseId)
                );

        courseRepository.delete(course);
    }
    private CourseResponseDTO buildCourseResponse(Course course) {

        CourseResponseDTO responseDTO = courseMapper.toResponseDTO(course);

        DepartmentResponseDTO department = departmentClient.getDepartmentById(
                course.getDepartmentId());

        TeacherResponseDTO teacher = teacherClient.getTeacherById(
                        course.getTeacherId());

        responseDTO.setDepartmentResponseDTO(department);
        responseDTO.setTeacherResponseDTO(teacher);

        return responseDTO;
    }
}
