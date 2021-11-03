package com.example.path_finder.repository;

import com.example.path_finder.models.enities.Role;
import com.example.path_finder.models.enities.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Role findByName(RoleNameEnum name);
}
