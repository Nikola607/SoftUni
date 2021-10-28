package com.example.path_finder.models.enities;

import com.example.path_finder.models.enities.enums.CategoryNameEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "categories")
public class Categories extends BaseEntity{
    private CategoryNameEnum name;
    private String description;

    public Categories() {
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    @Column(nullable = false, columnDefinition = "Text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
