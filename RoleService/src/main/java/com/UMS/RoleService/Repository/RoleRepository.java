package com.UMS.RoleService.Repository;

import com.UMS.RoleService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
