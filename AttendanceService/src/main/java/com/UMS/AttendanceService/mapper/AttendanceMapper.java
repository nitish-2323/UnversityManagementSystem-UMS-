package com.UMS.AttendanceService.mapper;

import com.UMS.AttendanceService.dto.AttendanceRequestDTO;
import com.UMS.AttendanceService.dto.AttendanceResponseDTO;
import com.UMS.AttendanceService.entity.Attendance;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {
    public Attendance toEntity(AttendanceRequestDTO dto) {

        Attendance attendance = new Attendance();

        attendance.setStudentId(dto.getStudentId());
        attendance.setCourseId(dto.getCourseId());
        attendance.setAttendanceDate(dto.getAttendanceDate());
        attendance.setStatus(dto.getStatus());
        attendance.setSemester(dto.getSemester());

        return attendance;
    }

    public AttendanceResponseDTO toResponseDTO(Attendance attendance) {

        AttendanceResponseDTO dto = new AttendanceResponseDTO();

        dto.setAttendanceId(attendance.getAttendanceId());
        dto.setStudentId(attendance.getStudentId());
        dto.setCourseId(attendance.getCourseId());
        dto.setAttendanceDate(attendance.getAttendanceDate());
        dto.setStatus(attendance.getStatus());
        dto.setSemester(attendance.getSemester());

        return dto;
    }
}
