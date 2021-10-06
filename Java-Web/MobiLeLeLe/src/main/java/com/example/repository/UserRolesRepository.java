package com.example.repository;

import com.example.models.entity.UserRoles;
import com.example.models.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
    UserRoles findByRole(Role role);
}
