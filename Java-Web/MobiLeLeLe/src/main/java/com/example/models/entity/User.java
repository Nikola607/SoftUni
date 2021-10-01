package com.example.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private UserRoles role;
    private String imageUrl;
    private Instant created;
    private Instant modified;

    public User() {
    }

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @ManyToOne
    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    @Column
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    @Column
    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    //     id – uuid or number.
// username – username of the user.
//             password – password of the user.
//             firstName – first name of the user.
// lastName – last name of the user.
// isActive – true OR false.
//             role – user&#39;s role (User or Admin).
//             imageUrl – a url of user&#39;s picture.
//             created – a date and time.
//             modified – a date and time.
}
