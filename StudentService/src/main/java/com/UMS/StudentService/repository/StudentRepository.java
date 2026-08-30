package com.UMS.StudentService.repository;

import com.UMS.StudentService.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Long> {
}
