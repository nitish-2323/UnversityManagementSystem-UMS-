package com.UMS.ExaminationService.repository;

import com.UMS.ExaminationService.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
