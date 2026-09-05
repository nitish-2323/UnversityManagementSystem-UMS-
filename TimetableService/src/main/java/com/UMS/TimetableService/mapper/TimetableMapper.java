package com.UMS.TimetableService.mapper;

import com.UMS.TimetableService.dto.TimetableRequestDTO;
import com.UMS.TimetableService.dto.TimetableResponseDTO;
import com.UMS.TimetableService.entity.Timetable;
import org.springframework.stereotype.Component;

@Component
public class TimetableMapper {
    public Timetable toEntity(TimetableRequestDTO dto) {

        Timetable timetable = new Timetable();

        timetable.setCourseId(dto.getCourseId());
        timetable.setTeacherId(dto.getTeacherId());
        timetable.setDepartmentId(dto.getDepartmentId());
        timetable.setSemester(dto.getSemester());
        timetable.setRoomNumber(dto.getRoomNumber());
        timetable.setDayOfWeek(dto.getDayOfWeek());
        timetable.setStartTime(dto.getStartTime());
        timetable.setEndTime(dto.getEndTime());
        timetable.setStatus(dto.getStatus());

        return timetable;
    }

    public TimetableResponseDTO toResponseDTO(Timetable timetable) {

        TimetableResponseDTO dto = new TimetableResponseDTO();

        dto.setTimetableId(timetable.getTimetableId());
        dto.setCourseId(timetable.getCourseId());
        dto.setTeacherId(timetable.getTeacherId());
        dto.setDepartmentId(timetable.getDepartmentId());
        dto.setSemester(timetable.getSemester());
        dto.setRoomNumber(timetable.getRoomNumber());
        dto.setDayOfWeek(timetable.getDayOfWeek());
        dto.setStartTime(timetable.getStartTime());
        dto.setEndTime(timetable.getEndTime());
        dto.setStatus(timetable.getStatus());
        dto.setCreatedAt(timetable.getCreatedAt());
        dto.setUpdatedAt(timetable.getUpdatedAt());

        return dto;
    }
}
