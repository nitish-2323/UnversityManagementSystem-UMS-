package com.UMS.TimetableService.client;

import com.UMS.TimetableService.dto.DepartmentResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DepartmentClient {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "DepartmentService", fallbackMethod = "departmentServiceFallback")
    public DepartmentResponseDTO getDepartmentById(Long departmentId) {

        return restTemplate.getForObject(
                "http://DepartmentService/departments/" + departmentId,
                DepartmentResponseDTO.class
        );
    }

    public DepartmentResponseDTO departmentServiceFallback(
            Long departmentId,
            Exception exception) {

        DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();

        responseDTO.setDepartmentName("Department Service Unavailable");

        return responseDTO;
    }
}
