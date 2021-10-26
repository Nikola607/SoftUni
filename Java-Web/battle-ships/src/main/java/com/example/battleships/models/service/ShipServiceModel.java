package com.example.battleships.models.service;

import com.example.battleships.models.entities.User;
import com.example.battleships.models.entities.enums.CategoryNamesEnum;

import java.time.LocalDate;

public class ShipServiceModel {
    private Long id;

    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNamesEnum category;
    private User user;

    public ShipServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryNamesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNamesEnum category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
