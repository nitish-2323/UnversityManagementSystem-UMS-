package com.UMS.EnrollementService.client;

import com.UMS.EnrollementService.dto.CourseResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
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

        CourseResponseDTO response = new CourseResponseDTO();

        response.setCourseId(courseId);
        response.setCourseName("Course Service Unavailable");
        return response;
    }
}
