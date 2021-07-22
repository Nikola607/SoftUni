package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "categories")
public class Categories extends BaseEntity{
    private String name;

    public Categories() {
    }

    @Column(length = 15, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
