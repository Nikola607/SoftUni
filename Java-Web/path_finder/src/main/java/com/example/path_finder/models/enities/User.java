package com.example.path_finder.models.enities;

import com.example.path_finder.models.enities.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity{
    private String username;
    private String fullName;
    private String password;
    private Integer age;
    private String email;
    private Set<Role> role;
    private LevelEnum level;

    public User() {
    }

    @Column(nullable = false)
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

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany
    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }
}
