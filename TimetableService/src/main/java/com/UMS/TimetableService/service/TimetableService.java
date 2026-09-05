package com.UMS.TimetableService.service;

import com.UMS.TimetableService.dto.TimetableRequestDTO;
import com.UMS.TimetableService.dto.TimetableResponseDTO;

import java.util.List;

public interface TimetableService {

    TimetableResponseDTO createTimetable(TimetableRequestDTO requestDTO);

    TimetableResponseDTO getTimetableById(Long timetableId);

    List<TimetableResponseDTO> getAllTimetables();

    TimetableResponseDTO updateTimetable(Long timetableId, TimetableRequestDTO requestDTO);

    void deleteTimetable(Long timetableId);
}
