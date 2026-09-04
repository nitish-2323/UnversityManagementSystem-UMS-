package com.UMS.AttendanceService.service;

import com.UMS.AttendanceService.client.CourseClient;
import com.UMS.AttendanceService.client.StudentClient;
import com.UMS.AttendanceService.dto.AttendanceRequestDTO;
import com.UMS.AttendanceService.dto.AttendanceResponseDTO;
import com.UMS.AttendanceService.dto.CourseResponseDTO;
import com.UMS.AttendanceService.dto.StudentResponseDTO;
import com.UMS.AttendanceService.entity.Attendance;
import com.UMS.AttendanceService.execption.AttendanceNotFoundException;
import com.UMS.AttendanceService.mapper.AttendanceMapper;
import com.UMS.AttendanceService.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService{
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;

    private final StudentClient studentClient;
    private final CourseClient courseClient;

    @Override
    public AttendanceResponseDTO createAttendance(
            AttendanceRequestDTO requestDTO) {

        Attendance attendance = attendanceMapper.toEntity(requestDTO);

        Attendance savedAttendance =
                attendanceRepository.save(attendance);

        return buildAttendanceResponse(savedAttendance);
    }

    @Override
    public AttendanceResponseDTO getAttendanceById(Long attendanceId) {

        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new AttendanceNotFoundException(
                        "Attendance not found with id: " + attendanceId));

        return buildAttendanceResponse(attendance);
    }

    @Override
    public List<AttendanceResponseDTO> getAllAttendance() {

        List<Attendance> attendances =
                attendanceRepository.findAll();

        return attendances.stream()
                .map(this::buildAttendanceResponse)
                .toList();
    }

    @Override
    public AttendanceResponseDTO updateAttendance(
            Long attendanceId,
            AttendanceRequestDTO requestDTO) {

        Attendance attendance =
                attendanceRepository.findById(attendanceId)
                        .orElseThrow(() -> new AttendanceNotFoundException(
                                "Attendance not found with id: "
                                        + attendanceId));

        attendance.setStudentId(requestDTO.getStudentId());
        attendance.setCourseId(requestDTO.getCourseId());
        attendance.setAttendanceDate(
                requestDTO.getAttendanceDate());
        attendance.setStatus(requestDTO.getStatus());
        attendance.setSemester(requestDTO.getSemester());

        Attendance updatedAttendance =
                attendanceRepository.save(attendance);

        return buildAttendanceResponse(updatedAttendance);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {

        Attendance attendance =
                attendanceRepository.findById(attendanceId)
                        .orElseThrow(() -> new AttendanceNotFoundException(
                                "Attendance not found with id: "
                                        + attendanceId));

        attendanceRepository.delete(attendance);
    }

    private AttendanceResponseDTO buildAttendanceResponse(
            Attendance attendance) {

        AttendanceResponseDTO responseDTO =
                attendanceMapper.toResponseDTO(attendance);

        StudentResponseDTO student =
                studentClient.getStudentById(
                        attendance.getStudentId());

        CourseResponseDTO course =
                courseClient.getCourseById(
                        attendance.getCourseId());

        responseDTO.setStudent(student);
        responseDTO.setCourse(course);

        return responseDTO;
    }
}
