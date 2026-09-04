package com.UMS.AttendanceService.client;

import com.UMS.AttendanceService.dto.CourseResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CourseClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(
            name = "CourseService",
            fallbackMethod = "courseServiceFallback"
    )
    public CourseResponseDTO getCourseById(Long courseId) {

        return restTemplate.getForObject(
                "http://CourseService/courses/" + courseId,
                CourseResponseDTO.class);
    }

    public CourseResponseDTO courseServiceFallback(
            Long courseId, Exception ex) {

        CourseResponseDTO responseDTO = new CourseResponseDTO();

        responseDTO.setCourseId(courseId);
        responseDTO.setCourseName("Course Service Unavailable");
        responseDTO.setStatus("SERVICE_UNAVAILABLE");

        return responseDTO;
    }
}