package com.example.battleships.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private String username;
    private String fullName;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegisterBindingModel() {
    }

    @Size(min = 3, max = 10)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 5, max = 20)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Size(min = 3)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Size(min = 3)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
