package com.UMS.AttendanceService.repository;

import com.UMS.AttendanceService.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}
