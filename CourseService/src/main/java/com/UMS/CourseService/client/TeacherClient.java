package com.UMS.CourseService.client;

import com.UMS.CourseService.dto.TeacherResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TeacherClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(
            name = "TeacherService",
            fallbackMethod = "teacherServiceFallback"
    )
    public TeacherResponseDTO getTeacherById(Long teacherId) {
        return restTemplate.getForObject(
                        "http://TeacherService/teachers/" + teacherId,
                TeacherResponseDTO.class);
    }

    public TeacherResponseDTO teacherServiceFallback(
            Long teacherId, Exception ex) {
        System.out.println("========== TEACHER SERVICE ERROR ==========");
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Exception: " + ex.getClass().getName());
        System.out.println("Message: " + ex.getMessage());
        ex.printStackTrace();
        System.out.println("============================================");

        TeacherResponseDTO response = new TeacherResponseDTO();

        response.setTeacherId(teacherId);
        response.setFirstName("Teacher Service Unavailable");
        response.setLastName("");
        response.setEmail("");
        response.setSpecialization("");

        return response;
    }
}
