package com.UMS.ExaminationService.client;

import com.UMS.ExaminationService.dto.TeacherResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TeacherClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "TeacherService",
            fallbackMethod = "teacherServiceFallback")
    public TeacherResponseDTO getTeacherById(Long teacherId) {

        return restTemplate.getForObject(
                "http://TeacherService/teachers/" + teacherId,
                TeacherResponseDTO.class
        );
    }

    public TeacherResponseDTO teacherServiceFallback(
            Long teacherId,
            Exception exception) {
        System.out.println("TEACHER ERROR: "
                + exception.getClass().getName());

        System.out.println("TEACHER MESSAGE: "
                + exception.getMessage());

        TeacherResponseDTO response = new TeacherResponseDTO();

        response.setTeacherId(teacherId);
        response.setFirstName("Service Unavailable");
        response.setLastName("Service Unavailable");

        return response;
    }
}
