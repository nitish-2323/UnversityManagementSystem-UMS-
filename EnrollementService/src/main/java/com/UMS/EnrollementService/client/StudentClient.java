package com.UMS.EnrollementService.client;

import com.UMS.EnrollementService.dto.StudentResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
@Controller
@RequiredArgsConstructor
public class StudentClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(
            name = "StudentService",
            fallbackMethod = "studentServiceFallback"
    )
    public StudentResponseDTO getStudentById(Long studentId) {

        return restTemplate.getForObject(
                "http://StudentService/students/" + studentId,
                StudentResponseDTO.class);
    }

    public StudentResponseDTO studentServiceFallback(
            Long studentId, Exception ex) {

        StudentResponseDTO response = new StudentResponseDTO();

        response.setStudentId(studentId);
        response.setFirstName("Student Service Unavailable");
        return response;
    }
}
