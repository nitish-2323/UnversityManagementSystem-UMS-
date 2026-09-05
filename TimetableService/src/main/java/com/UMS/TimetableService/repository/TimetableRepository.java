package com.UMS.TimetableService.repository;

import com.UMS.TimetableService.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable,Long> {
}
