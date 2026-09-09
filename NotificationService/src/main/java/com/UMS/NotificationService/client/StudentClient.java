package com.UMS.NotificationService.client;

import com.UMS.NotificationService.dto.StudentResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class StudentClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "StudentService",
            fallbackMethod = "studentServiceFallback"
    )
    public StudentResponseDTO getStudentById(Long studentId) {
        return restTemplate.getForObject(
                        "http://StudentService/students/" + studentId, StudentResponseDTO.class);
    }

    public StudentResponseDTO studentServiceFallback(
            Long studentId, Exception ex) {

        StudentResponseDTO response = new StudentResponseDTO();
        response.setStudentId(studentId);
        response.setFirstName("Student");
        response.setLastName("Service Unavailable");

        return response;
    }
}
