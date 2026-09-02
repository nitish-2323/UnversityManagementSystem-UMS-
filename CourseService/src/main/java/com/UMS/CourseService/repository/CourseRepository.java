package com.UMS.CourseService.repository;

import com.UMS.CourseService.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
