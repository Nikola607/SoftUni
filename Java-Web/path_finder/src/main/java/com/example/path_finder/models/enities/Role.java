package com.example.path_finder.models.enities;

import com.example.path_finder.models.enities.enums.RoleNameEnum;

import javax.persistence.*;

@Entity(name = "roles")
public class Role extends BaseEntity{
    private RoleNameEnum name;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }

}
