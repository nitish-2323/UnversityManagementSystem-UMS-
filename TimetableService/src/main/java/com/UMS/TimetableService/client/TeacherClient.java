package com.UMS.TimetableService.client;

import com.UMS.TimetableService.dto.TeacherResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TeacherClient {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "TeacherService", fallbackMethod = "teacherServiceFallback")
    public TeacherResponseDTO getTeacherById(Long teacherId) {

        return restTemplate.getForObject(
                "http://TeacherService/teachers/" + teacherId,
                TeacherResponseDTO.class
        );
    }

    public TeacherResponseDTO teacherServiceFallback(
            Long teacherId,
            Exception exception) {

        TeacherResponseDTO responseDTO = new TeacherResponseDTO();

        responseDTO.setFirstName("Teacher Service Unavailable");

        return responseDTO;
    }
}
