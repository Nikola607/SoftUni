package personal.project.two_vago.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import personal.project.two_vago.models.entities.Role;

@SessionScope
@Component
public class CurrentUser {
    private Long id;

    private String username;
    private String fullName;
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
