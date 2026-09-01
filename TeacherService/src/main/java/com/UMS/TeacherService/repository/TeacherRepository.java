package com.UMS.TeacherService.repository;

import com.UMS.TeacherService.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
