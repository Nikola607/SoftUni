package com.example.path_finder.security;

import com.example.path_finder.models.enities.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@SessionScope
@Component
public class CurrentUser {
    private Long id;
    private String username;
    private String fullName;
    private boolean isLoggedIn;
    private Set<Role> roles = new HashSet<>();

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {

        return this.getRoles().stream().map(role -> role.getName().toString())
                .anyMatch(n -> n.equals("ADMIN"));
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void clearRoles() {
        this.roles.clear();
    }

    public void clearCurrentUser() {
        this.setLoggedIn(false);
        this.setUsername(null);
        this.setFullName(null);
        this.clearRoles();
    }
}
