package com.UMS.FeeService.client;

import com.UMS.FeeService.dto.StudentResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class StudentClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "StudentService",
            fallbackMethod = "studentFallback")
    public StudentResponseDTO getStudentById(Long studentId) {

        String url = "http://StudentService/students/" + studentId;

        ResponseEntity<StudentResponseDTO> response =
                restTemplate.getForEntity(
                        url,
                        StudentResponseDTO.class
                );

        return response.getBody();
    }

    public StudentResponseDTO studentFallback(
            Long studentId, Throwable throwable) {
        StudentResponseDTO response = new StudentResponseDTO();
        response.setStudentId(studentId);
        response.setFirstName("Student Service Unavailable");
        response.setLastName(null);
        response.setEmail(null);
        response.setStatus(null);
        return response;

    }
}
