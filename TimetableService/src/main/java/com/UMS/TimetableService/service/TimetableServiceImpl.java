package com.UMS.TimetableService.service;

import com.UMS.TimetableService.client.CourseClient;
import com.UMS.TimetableService.client.DepartmentClient;
import com.UMS.TimetableService.client.TeacherClient;
import com.UMS.TimetableService.dto.TimetableRequestDTO;
import com.UMS.TimetableService.dto.TimetableResponseDTO;
import com.UMS.TimetableService.entity.Timetable;
import com.UMS.TimetableService.execption.TimetableNotFoundException;
import com.UMS.TimetableService.mapper.TimetableMapper;
import com.UMS.TimetableService.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService{
    private final TimetableRepository timetableRepository;

    private final TimetableMapper timetableMapper;

    private final CourseClient courseClient;

    private final TeacherClient teacherClient;

    private final DepartmentClient departmentClient;


    @Override
    public TimetableResponseDTO createTimetable(
            TimetableRequestDTO requestDTO) {

        Timetable timetable = timetableMapper.toEntity(requestDTO);

        timetable.setCreatedAt(LocalDateTime.now());
        timetable.setUpdatedAt(LocalDateTime.now());

        Timetable savedTimetable = timetableRepository.save(timetable);

        return getTimetableResponse(savedTimetable);
    }


    @Override
    public TimetableResponseDTO getTimetableById(Long timetableId) {

        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() ->
                        new TimetableNotFoundException(
                                "Timetable not found with id: " + timetableId
                        ));

        return getTimetableResponse(timetable);
    }


    @Override
    public List<TimetableResponseDTO> getAllTimetables() {

        return timetableRepository.findAll()
                .stream()
                .map(this::getTimetableResponse)
                .toList();
    }


    @Override
    public TimetableResponseDTO updateTimetable(
            Long timetableId,
            TimetableRequestDTO requestDTO) {

        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() ->
                        new TimetableNotFoundException(
                                "Timetable not found with id: " + timetableId
                        ));

        timetable.setCourseId(requestDTO.getCourseId());
        timetable.setTeacherId(requestDTO.getTeacherId());
        timetable.setDepartmentId(requestDTO.getDepartmentId());
        timetable.setSemester(requestDTO.getSemester());
        timetable.setRoomNumber(requestDTO.getRoomNumber());
        timetable.setDayOfWeek(requestDTO.getDayOfWeek());
        timetable.setStartTime(requestDTO.getStartTime());
        timetable.setEndTime(requestDTO.getEndTime());
        timetable.setStatus(requestDTO.getStatus());

        timetable.setUpdatedAt(LocalDateTime.now());

        Timetable updatedTimetable =
                timetableRepository.save(timetable);

        return getTimetableResponse(updatedTimetable);
    }


    @Override
    public void deleteTimetable(Long timetableId) {

        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() ->
                        new TimetableNotFoundException(
                                "Timetable not found with id: " + timetableId
                        ));

        timetableRepository.delete(timetable);
    }


    private TimetableResponseDTO getTimetableResponse(
            Timetable timetable) {

        TimetableResponseDTO responseDTO =
                timetableMapper.toResponseDTO(timetable);

        responseDTO.setCourseResponseDTO(
                courseClient.getCourseById(timetable.getCourseId())
        );

        responseDTO.setTeacherResponseDTO(
                teacherClient.getTeacherById(timetable.getTeacherId())
        );

        responseDTO.setDepartmentResponseDTO(
                departmentClient.getDepartmentById(timetable.getDepartmentId()));

        return responseDTO;
    }
}
