package com.UMS.TimetableService.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimetableRequestDTO {
    private Long courseId;

    private Long teacherId;

    private Long departmentId;

    private String semester;

    private String roomNumber;

    private String dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status;
}
