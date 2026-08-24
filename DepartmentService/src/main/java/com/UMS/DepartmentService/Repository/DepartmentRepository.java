package com.UMS.DepartmentService.Repository;

import com.UMS.DepartmentService.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
