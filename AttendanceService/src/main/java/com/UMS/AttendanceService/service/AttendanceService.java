package com.UMS.AttendanceService.service;

import com.UMS.AttendanceService.dto.AttendanceRequestDTO;
import com.UMS.AttendanceService.dto.AttendanceResponseDTO;

import java.util.List;

public interface AttendanceService {
    AttendanceResponseDTO createAttendance(AttendanceRequestDTO requestDTO);

    AttendanceResponseDTO getAttendanceById(Long attendanceId);

    List<AttendanceResponseDTO> getAllAttendance();

    AttendanceResponseDTO updateAttendance(
            Long attendanceId, AttendanceRequestDTO requestDTO);

    void deleteAttendance(Long attendanceId);
}
