package com.example.models.entity;

import com.example.models.entity.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "roles")
public class UserRoles extends BaseEntity{
    private Role role;

    public UserRoles() {
    }

    @Column
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
