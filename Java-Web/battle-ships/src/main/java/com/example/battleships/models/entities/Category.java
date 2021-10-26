package com.example.battleships.models.entities;

import com.example.battleships.models.entities.enums.CategoryNamesEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "categories")
public class Category extends BaseEntity{
    private CategoryNamesEnum name;
    private String description;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryNamesEnum getName() {
        return name;
    }

    public void setName(CategoryNamesEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "Text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
