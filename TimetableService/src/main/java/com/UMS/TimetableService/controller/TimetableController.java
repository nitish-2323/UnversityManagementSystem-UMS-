package com.UMS.TimetableService.controller;

import com.UMS.TimetableService.dto.TimetableRequestDTO;
import com.UMS.TimetableService.dto.TimetableResponseDTO;
import com.UMS.TimetableService.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;


    @PostMapping
    public ResponseEntity<TimetableResponseDTO> createTimetable(
            @RequestBody TimetableRequestDTO requestDTO) {
        TimetableResponseDTO responseDTO =
                timetableService.createTimetable(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/{timetableId}")
    public ResponseEntity<TimetableResponseDTO> getTimetableById(
            @PathVariable Long timetableId) {

        TimetableResponseDTO responseDTO =
                timetableService.getTimetableById(timetableId);

        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping
    public ResponseEntity<List<TimetableResponseDTO>> getAllTimetables() {

        List<TimetableResponseDTO> responseDTO =
                timetableService.getAllTimetables();

        return ResponseEntity.ok(responseDTO);
    }


    @PutMapping("/{timetableId}")
    public ResponseEntity<TimetableResponseDTO> updateTimetable(
            @PathVariable Long timetableId,
            @RequestBody TimetableRequestDTO requestDTO) {

        TimetableResponseDTO responseDTO =
                timetableService.updateTimetable(timetableId, requestDTO);

        return ResponseEntity.ok(responseDTO);
    }


    @DeleteMapping("/{timetableId}")
    public ResponseEntity<String> deleteTimetable(
            @PathVariable Long timetableId) {

        timetableService.deleteTimetable(timetableId);

        return ResponseEntity.ok("Timetable deleted successfully");
    }
}
