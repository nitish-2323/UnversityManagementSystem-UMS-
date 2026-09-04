package com.UMS.AttendanceService.controller;

import com.UMS.AttendanceService.dto.AttendanceRequestDTO;
import com.UMS.AttendanceService.dto.AttendanceResponseDTO;
import com.UMS.AttendanceService.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<AttendanceResponseDTO> createAttendance(
            @RequestBody AttendanceRequestDTO requestDTO) {

        return new ResponseEntity<>(attendanceService.createAttendance(requestDTO),
                HttpStatus.CREATED);
    }

    @GetMapping("/{attendanceId}")
    public ResponseEntity<AttendanceResponseDTO> getAttendanceById(
            @PathVariable Long attendanceId) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceById(attendanceId));
    }

    @GetMapping
    public ResponseEntity<List<AttendanceResponseDTO>> getAllAttendance() {

        return ResponseEntity.ok(
                attendanceService.getAllAttendance());
    }

    @PutMapping("/{attendanceId}")
    public ResponseEntity<AttendanceResponseDTO> updateAttendance(
            @PathVariable Long attendanceId,
            @RequestBody AttendanceRequestDTO requestDTO) {

        return ResponseEntity.ok(
                attendanceService.updateAttendance(attendanceId, requestDTO));
    }

    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(
            @PathVariable Long attendanceId) {

        attendanceService.deleteAttendance(attendanceId);

        return ResponseEntity.noContent().build();
    }
}
