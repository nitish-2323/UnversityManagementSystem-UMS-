package com.UMS.CourseService.mapper;

import com.UMS.CourseService.dto.CourseRequestDTO;
import com.UMS.CourseService.dto.CourseResponseDTO;
import com.UMS.CourseService.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course toEntity(CourseRequestDTO dto) {

        Course course = new Course();

        course.setCourseCode(dto.getCourseCode());
        course.setCourseName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setCredits(dto.getCredits());
        course.setDepartmentId(dto.getDepartmentId());
        course.setTeacherId(dto.getTeacherId());
        course.setSemester(dto.getSemester());
        course.setStatus(dto.getStatus());

        return course;
    }


    public CourseResponseDTO toResponseDTO(Course course) {

        CourseResponseDTO dto = new CourseResponseDTO();

        dto.setCourseId(course.getCourseId());
        dto.setCourseCode(course.getCourseCode());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setCredits(course.getCredits());
        dto.setDepartmentId(course.getDepartmentId());
        dto.setTeacherId(course.getTeacherId());
        dto.setSemester(course.getSemester());
        dto.setStatus(course.getStatus());
        dto.setCreatedAt(course.getCreatedAt());
        dto.setUpdatedAt(course.getUpdatedAt());

        return dto;
    }


    public void updateEntity(Course course, CourseRequestDTO dto) {

        course.setCourseCode(dto.getCourseCode());
        course.setCourseName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setCredits(dto.getCredits());
        course.setDepartmentId(dto.getDepartmentId());
        course.setTeacherId(dto.getTeacherId());
        course.setSemester(dto.getSemester());
        course.setStatus(dto.getStatus());
    }
}
