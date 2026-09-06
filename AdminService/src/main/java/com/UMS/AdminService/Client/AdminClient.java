package com.UMS.AdminService.Client;

import com.UMS.AdminService.DTO.DepartmentResponseDTO;
import com.UMS.AdminService.DTO.RoleResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AdminClient {
    private final RestTemplate restTemplate;

    @CircuitBreaker(
            name ="departmentService",
            fallbackMethod = "departmentServiceFallback"
    )
    public DepartmentResponseDTO getDepartmentById(Long departmentId){
        return restTemplate.getForObject("http://DepartmentService/departments/"+departmentId
                ,DepartmentResponseDTO.class);
    }
    public DepartmentResponseDTO departmentServiceFallback(Long departmentId, Exception ex) {
        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setDepartmentId(departmentId);
        response.setDepartmentName("Department Service Unavailable");
        return response;
    }

    @CircuitBreaker(
            name="roleService",
            fallbackMethod = "roleServiceFallback"
    )
    public RoleResponseDTO getRoleById(Long roleId) {
        return restTemplate.getForObject(
                "http://RoleService/api/roles/" + roleId,
                RoleResponseDTO.class
        );
    }
    public RoleResponseDTO roleServiceFallback(Long roleId, Exception ex) {
        RoleResponseDTO response = new RoleResponseDTO();
        response.setRoleId(roleId);
        response.setRoleName("Role Service Unavailable");
        return response;
    }
}
