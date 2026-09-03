package com.UMS.EnrollementService.repository;

import com.UMS.EnrollementService.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

}
