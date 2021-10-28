package com.example.path_finder.models.enities;

import com.example.path_finder.models.enities.enums.RoleNameEnum;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class Role extends BaseEntity{
    private RoleNameEnum name;
    private Set<User> user;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
